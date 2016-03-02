<div class="modal fade" id="forgotpassward" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Forgot Password</h4>
            </div>
            <g:form controller="topic" action="save" >
                <div class="modal-body">
                    <div class="form-group">
                        <div class="col-lg-2">
                            <label>Email-Id<span style="color:red">*</span>:</label>
                        </div>
                        <div class="col-lg-10">
                            <g:field type="email" required="" class="form-control" id="email" name="email" placeholder="Enter your Mail-id"/>
                        </div>
                    </div>
                    <br><br>
                </div>
                <div class="modal-footer">
                    <div class="row">

                        <div class="col-lg-4 col-lg-offset-2">
                            <g:actionSubmit value="Send" class="btn btn-info"></g:actionSubmit>
                        </div>
                        <div class="col-lg-3">
                            <button type="button" class="btn btn-info" data-dismiss="modal">Cancel</button>
                        </div>
                    </div>
                </div>
            </g:form>
        </div>
    </div>
</div>