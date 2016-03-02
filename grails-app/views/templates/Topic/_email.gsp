<%@page import="com.ttnd.LinkSharing.*" %>
<div class="modal fade" id="sendInv" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Send Invitation</h4>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                      <div class="col-lg-3">
                        <label for="email">Email-Id<span style="color:red">*</span>:</label>
                       </div>
                        <div class="col-lg-8">

                            <input type="email" class="form-control" id="email" placeholder="Enter your Email-Id">
 </div>
                    </div>
                    <br><br><br>
                    <div class="form-group">
                        <div class="col-lg-3">
                            <label>Topic<span style="color:red">*</span>:</label>
                        </div>
                        <div class="col-lg-8">
                            <select class="form-control">
                                <g:each in="${User.getSubscribedTopic(session?.user)}">

                                    <option>${it}</option>
                                </g:each>
                            </select>
                        </div>
                        <br><br>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <div class="row">

                    <div class="col-lg-4 col-lg-offset-2">
                        <button type="button" class="btn btn-info">Invite</button>
                    </div>
                    <div class="col-lg-4">
                        <button type="button" class="btn btn-info" data-dismiss="modal">Cancel</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
