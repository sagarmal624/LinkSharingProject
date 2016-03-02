<div class="modal fade" id="createTopic" role="dialog">
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Create Topics</h4>
        </div>
        <g:form controller="topic" action="save" >
        <div class="modal-body">
                <div class="form-group">
                    <div class="col-lg-2">
                    <label for="name">Name<span style="color:red">*</span>:</label>
                    </div>
                    <div class="col-lg-10">
                    <g:textField required="" class="form-control" id="name" name="name" placeholder="Enter your Name"/>
                  </div>
                </div>
                <br><br>
                <div class="form-group">
                    <div class="col-lg-2">

                    <label>Visibility:</label>
                 </div>
                       <div class="col-lg-10">
          <select class="form-control"  name="visibility" data-toggle="tooltip" title="Delete Edit and private will show to topic creater and admin">
                        <option>PUBLIC</option>
                        <option>PRIVATE</option>
                    </select>
                    </div>
                </div>
            <br><br>
       </div>
        <div class="modal-footer">
            <div class="row">

                <div class="col-lg-4 col-lg-offset-2">
                    <g:actionSubmit value="Save" class="btn btn-info"></g:actionSubmit>
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