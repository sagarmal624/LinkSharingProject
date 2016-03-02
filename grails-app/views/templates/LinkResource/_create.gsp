<%@page import="com.ttnd.LinkSharing.*" %>
<div class="modal fade" id="shareLink" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Share Link</h4>
            </div>


            <div class="modal-body">
                <g:form controller="resource" action="save">
                    <div class="form-group">
                        <div class="col-lg-3">
                            <label>Link<span style="color:red">*</span>:</label>
                        </div>
                        <div class="col-lg-8">
                            <g:field type="url" required=""  name="url" class="form-control offset-5" id="url" placeholder="Enter URL"/>
                            <g:fieldError field="url" bean="resource"></g:fieldError>
                        </div>
                    </div>
                    <br><br><br>
                    <div class="form-group">
                        <div class="col-lg-3">
                            <label>Description:</label>
                        </div>
                        <div class="col-lg-8">
                            <g:textArea name="description" required="" class="form-control" cols="15" ></g:textArea>
                        </div>
                    </div>
                    <br><br><br>
                    <div class="form-group">
                        <div class="col-lg-3">
                            <label></label>Topic<span style="color:red">*</span>:</label>
                        </div>
                        <div class="col-lg-8">
                            <select class="form-control" name="topicname">
                       <g:each in="${User.getSubscribedTopic(session?.user)}">

                                <option>${it}</option>
                     </g:each>
                            </select>
                        </div>
                        <br><br>
                    </div>
             <div class="modal-footer">
                <div class="row">
                    <div class="col-lg-4 col-lg-offset-2">
                        <g:actionSubmit  controller="resource" action="save" value="Share" class="btn btn-info">Share</g:actionSubmit>
                    </div>
                    <div class="col-lg-4">
                        <button type="button" class="btn btn-info" data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
                  </g:form>
            </div>

        </div>
    </div>
</div>
