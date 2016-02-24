package org.grails.plugins.console

import groovy.ui.SystemOutputInterceptor
import org.codehaus.groovy.control.CompilerConfiguration
import org.codehaus.groovy.control.customizers.ImportCustomizer
import org.codehaus.groovy.grails.commons.GrailsApplication

class ConsoleService {

    static transactional = false

    GrailsApplication grailsApplication

    /**
     * @param code Groovy code to execute
     * @param autoImportDomains if <code>true</code>, adds imports for each domain class
     * @return an Evaluation
     */
    Evaluation eval(String code, boolean autoImportDomains, request) {
        log.trace "eval() code: $code"

        ByteArrayOutputStream baos = new ByteArrayOutputStream()
        PrintStream out = new PrintStream(baos)

        SystemOutputInterceptor systemOutInterceptor = createInterceptor(out)
        systemOutInterceptor.start()

        Evaluation evaluation = new Evaluation()

        long startTime = System.currentTimeMillis()

        try {
            Binding binding = createBinding(request, out)
            CompilerConfiguration configuration = createConfiguration(autoImportDomains)

            GroovyShell groovyShell = new GroovyShell(grailsApplication.classLoader, binding, configuration)
            evaluation.result = groovyShell.evaluate code
        } catch (Throwable t) {
            evaluation.exception = t
        }

        evaluation.totalTime = System.currentTimeMillis() - startTime
        systemOutInterceptor.stop()

        evaluation.output = baos.toString('UTF8')
        evaluation
    }

    private static SystemOutputInterceptor createInterceptor(PrintStream out) {
        new SystemOutputInterceptor({ String s ->
            out.println s
            return false
        })
    }

    private Binding createBinding(request, PrintStream out) {
        new Binding([
            session          : request.session,
            request          : request,
            ctx              : grailsApplication.mainContext,
            grailsApplication: grailsApplication,
            config           : grailsApplication.config,
            log              : log,
            out              : out
        ])
    }

    private CompilerConfiguration createConfiguration(boolean autoImportDomains) {
        CompilerConfiguration configuration = new CompilerConfiguration()
        if (autoImportDomains) {
            ImportCustomizer importCustomizer = new ImportCustomizer()
            importCustomizer.addImports(*grailsApplication.domainClasses*.fullName)
            configuration.addCompilationCustomizers importCustomizer
        }
        configuration
    }
}
