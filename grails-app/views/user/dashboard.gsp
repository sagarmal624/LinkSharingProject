<%@page import="java.nio.file.Files; com.ttnd.LinkSharing.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta name="layout" content="application"/>
   <title>Welcome to LinkSharing</title>
   <script type="text/javascript">
      $(document).ready(function(){
         $('[data-toggle="tooltip"]').tooltip({trigger:"hover"});

      });
   </script>
   <style type="text/css">
   html,body{
      %{--background-image: url("${resource(dir:"../grails-app/assets/images/",file:"img.gif")}") ;--}%


   }
   </style>
</head>
<body style="background-image: url('../../assets/images/img.gif')">
<nav class="navbar navbar-default" role="navigation" style="background-color:lightskyblue">
   <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
         <span class="sr-only">Toggle navigation</span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Link Sharing</a>
   </div>
   <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <div class="col-sm-5 col-md-5 pull-right">
         <form class="navbar-form" role="search">
            <div class="input-group">
               <input type="text" class="form-control" placeholder="Search" name="q">
               <div class="input-group-btn">
                  <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
               </div>
            </div>
            <div class="input-group">
               <span class="glyphicon glyphicon-comment" data-target="#createTopic" data-toggle="modal" style="border-radious:5px solid;font-size:20px;padding-left:10px;"
                     data-toggle="tooltip" title="Create Topic">
               </span>
            </div>
            <div class="input-group">
               <span class="glyphicon glyphicon-envelope" data-target="#sendInv" data-toggle="modal" style="font-size:20px;padding-left:10px;"
                     data-toggle="tooltip" title="Send Invitation">
               </span>
            </div>
            <div class="input-group">
               <span data-target="#shareLink"data-toggle="modal" class="glyphicon glyphicon-link" style="font-size:20px;padding-left:10px;"
                     data-toggle="tooltip" title="Create Link Resource">
               </span>
            </div>
            <div class="input-group">
               <span data-target="#shareDoc"data-toggle="modal"  class="glyphicon glyphicon-file" style="font-size:20px;padding-left:10px;"
                     data-toggle="tooltip" title="Create Document Resource"   ></span>
            </div>
            <div class="input-group">
               <span class="glyphicon glyphicon-user" style="font-size:20px"></span>
            </div>
            <div class="input-group">
               <button class="btn btn-info dropdown-toggle" type="button" data-toggle="dropdown">Sagar
                  <span class="caret"></span></button>
               <ul class="dropdown-menu">
                  <li><a href="#">Prfile</a></li>
                  <li><a href="#">Users</a></li>
                  <li><a href="#">Topics</a></li>
                  <li><a href="#">Post</a></li>
                  <li><a href="${createLink(controller:"login",action: "logout" )}">Logout</a></li>
               </ul>
            </div>
         </form>
      </div>
   </div>
</nav>
<div class="container">

   <div class="row">

      <div class="row">
      <div class="col-lg-offset-0"/>
      <div class="col-lg-12">
         <div class="col-lg-5">
            <span>${flash.message}</span>
            <span>${flash.error}</span>

            <div class="panel panel-default" style="border:2px solid gray;border-radius:10px">
               <div class="panel-body">

                  <div class="col-lg-3">
                     <span>
                      <asset:image src="1.png" style="border:1px solid;border-radius: 15px;"/>


                     </span>
                  </div>
                  <div class="col-lg-9">
                     <span>SagarMalShankhala</span><br>
                     <span class="text-muted">@sagar</span>
                     <br>
                     <div class="row">
                        <div class="col-lg-7">
                           <span class="text-muted">Subscriptions</span>
                        </div>
                        <div class="col-lg-3">
                           <span class="text-muted">Topics</span>
                        </div>
                     </div>
                     <br>
                     <div class="row">
                        <div class="col-lg-7">
                           <span class="badge" style="color:aqua">50</span>
                        </div>
                        <div class="col-lg-5">
                           <span class="badge" style="color:aqua">30</span>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <div class="panel panel-default" style="border:1px solid gray;border-radius:10px">
               <div class="panel-heading"  style="border:1px solid gray;border-radius:5px">
                  <span>
                     Subscriptions
                  </span>
                  <span  class="col-lg-offset-5"><a href="#"><u>View All</u></a></span>
               </div>
               <div class="panel-body">
                  <div class="row">
                     <div class="col-lg-2">
                        <span>  <asset:image src="1.png"  style="border:1px solid;border-radius: 15px;"/></span>
                        <!--<span class="glyphicon glyphicon-user" style="font-size:50px;border:1px solid"></span>
                                 -->
                     </div>
                     <div class="col-lg-10">
                        <span>
                           <a href="#">
                              <div class="row">
                                 <div class="col-lg-1"></div>
                                 <div class="col-lg-5">Grails</div>
                              </div>
                           </a>
                        </span>
                        <br>
                        <span class="text-muted">
                           <div class="row">
                              <div class="col-lg-1"></div>
                              <div class="col-lg-3">@Sagar</div>
                              <div class="col-lg-4">Subscriptions</div>
                              <div class="col-lg-3">Post</div>
                           </div>
                        </span>
                        <br>
                        <div class="row">
                           <div class="col-lg-5">
                              <span><a href="#">Unsubscribe</a></span>
                           </div>
                           <div class="col-lg-3">
                              <span class="badge"style="color:aqua">50</span>
                           </div>
                           <div class="col-lg-2">
                              <span class="badge" style="color:aqua">50</span>
                           </div>
                        </div>
                        <br>
                     </div>
                     <div class="row" style="padding-bottom:10px">
                        <div class="col-lg-5">
                           <span class="col-lg-12">
                              <select class="form-control" style="font-size:11px">
                                 <option>Serious</option>
                                 <option>Non Serious</option>
                              </select>
                           </span>
                        </div>
                        <div class="col-lg-4">
                           <select class="form-control" style="font-size:11px"
                                   data-placement="top" data-toggle="tooltip" title="Delete,edit and private will show to topic creater and admin">

                              >
                              <option>Private</option>
                              <option>Public</option>
                           </select>
                        </div>
                        <div class="col-lg-3">
                           <span class="glyphicon glyphicon-envelope" style="font-size:25px"></span>
                           <span class="glyphicon glyphicon-file" style="font-size:25px"></span>
                           <span class="glyphicon glyphicon-trash"style="font-size:25px" ></span>
                        </div>
                     </div>
                  </div>
                  <div class="row"  style="border-top:1px solid gray;padding-top:15px;">
                     <div class="col-lg-2">
                        <!--<span class="glyphicon glyphicon-user" style="font-size:50px;border:1px solid"></span>
                                 -->
                        <span><asset:image src="1.png"  style="border:1px solid;border-radius: 15px;"/></span>
                     </div>
                     <div class="col-lg-10">
                        <span>
                           <a href="#">
                              <div class="row">
                                 <div class="col-lg-1"></div>
                                 <div class="col-lg-5">Grails</div>
                              </div>
                           </a>
                        </span>
                        <br>
                        <span class="text-muted">
                           <div class="row">
                              <div class="col-lg-1"></div>
                              <div class="col-lg-3">@Sagar</div>
                              <div class="col-lg-4">Subscriptions</div>
                              <div class="col-lg-3">Post</div>
                           </div>
                        </span>
                        <br>
                        <div class="row">
                           <div class="col-lg-5">
                              <span><a href="#">Unsubscribe</a></span>
                           </div>
                           <div class="col-lg-3">
                              <span class="badge"style="color:aqua">50</span>
                           </div>
                           <div class="col-lg-2">
                              <span class="badge" style="color:aqua">50</span>
                           </div>
                        </div>
                        <br>
                     </div>
                     <div class="row">
                        <div class="col-lg-5"></div>
                        <div class="col-lg-5">
                           <span class="col-lg-14">
                              <select class="form-control" style="font-size:11px"
                                      data-placement="top" data-toggle="tooltip" title="If User is subscribed to this topic ,user can send invitation and change seriousness so only above two buttons will show">

                                 <option>Serious</option>
                                 <option>Non Serious</option>
                              </select>
                           </span>
                        </div>
                        <div class="col-lg-2">
                           <span class="glyphicon glyphicon-envelope" style="font-size:30px"
                                 data-placement="right" data-toggle="tooltip" title="it Will open send invitation pop up and topic name will be displayed instead of drop down"

                           ></span>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <div class="panel-group">
               <div class="panel panel-default" style="border:1px solid gray">
                  <div class="panel-heading"  style="border:1px solid gray">Trending Topics</div>
                  <div class="panel-body">
                     <g:each in="${Topic.getTrendingTopics()}" var="i">
                        <div class="row">
                        <div class="col-lg-3">
                           <span><asset:image src="1.png"  style="border:1px solid;border-radius: 15px;"/></span>
                        </div>
                        <div class="col-lg-9">
                           <span>
                              <a href="#">
                                 <div class="row">
                                    <div class="col-lg-0"></div>
                                    <div class="col-lg-5">${i.name}</div>
                                 </div>
                              </a>
                           </span>
                           <br>
                           <span class="text-muted">
                              <div class="row">
                                 <div class="col-lg-0"></div>
                                 <div class="col-lg-3">@${i.createdBy}</div>
                                 <div class="col-lg-5">Subscriptions</div>
                                 <div class="col-lg-3">Post</div>
                              </div>
                           </span>
                           <br>
                           <div class="row" style="padding-bottom:15px;">
                              <div class="col-lg-0"></div>
                              <div class="col-lg-4">
                                 <span><a href="#" data-placement="top" data-toggle="tooltip" title="Subscribe will show if user not subscribe to topic."
                                 >Subscribe</a></span>
                              </div>
                              <div class="col-lg-4">
                                 <span class="badge"style="color:aqua">${Subscription.countByTopic(Topic.findByCreatedByAndName(i.createdBy,i.name))}</span>
                              </div>
                              <div class="col-lg-2">
                                 <span class="badge" style="color:aqua">50</span>
                              </div>
                           </div>
                        </div>
                     </div>
                        </g:each>
                     <div class="row"  style="border-top:1px solid gray;padding-top:15px;">
                        <div class="col-lg-2">
                           <span><asset:image src="1.png"  style="border:1px solid;border-radius: 15px;"/></span>
                        </div>
                        <div class="col-lg-10">
                           <div class="col-lg-4">
                              <input type="text" class="form-control" placeholder="Grails">
                           </div>
                           <div class="col-lg-4">
                              <!--<button type="button" class="form-control" placeholder="Grails">-->
                              <button type="button" class="btn btn-info form-control">Save</button>
                           </div>
                           <div class="col-lg-4">
                              <!--<button type="button" class="form-control" placeholder="Grails">-->
                              <button type="button" class=" btn btn-info form-control">Cancel</button>
                           </div>
                           <span class="text-muted">
                              <div class="row">
                                 <div class="col-lg-1"></div>
                                 <div class="col-lg-3">@Sagar</div>
                                 <div class="col-lg-4">  Subscriptions</div>
                                 <div class="col-lg-3">post</div>
                              </div>
                           </span>


                        </div>

                        <div class="row" style="padding-bottom:15px;">
                           <div class="col-lg-1"></div>
                           <div class="col-lg-3" style="margin-left:-10px">
                              <span><a href="#" data-placement="top" data-toggle="tooltip" title="Subscribe will show if user not subscribe to topic."
                              >Subscribe</a></span>
                           </div>
                           <div class="col-lg-3">
                              <span class="badge"style="color:aqua;">50</span>
                           </div>
                           <div class="col-lg-2">
                              <span class="badge" style="color:aqua;margin-left:-8px">50</span>
                           </div>
                        </div>


                     </div>
                     <br>
                     <div class="row">
                        <div class="col-lg-5">
                           <select class="form-control" style="font-size:11px">
                              <option>Serious</option>
                              <option>Non Serious</option>
                           </select>
                        </div>
                        <div class="col-lg-4">
                           <select class="form-control" style="font-size:11px"
                                   data-placement="top" data-toggle="tooltip" title="Delete Edit and private will show to topic creater and admin"
                           >
                              <option>Private</option>
                              <option>Public</option>
                           </select>
                        </div>
                        <div class="col-lg-3">
                           <span class="glyphicon glyphicon-envelope" style="font-size:25px"></span>
                           <span class="glyphicon glyphicon-file" style="font-size:25px"
                                 data-placement="top" data-toggle="tooltip" title="Click of Edit 'Grails' Link Will become editable and textfield will show and on click of cancel again link will show and textfild will be hidden.">

                           </span>
                           <span class="glyphicon glyphicon-trash"style="font-size:25px" ></span>
                        </div>
                     </div>
                     <div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
         <div class="col-lg-7">
            <div class="panel-group"  data-placement="top" data-toggle="tooltip" title="Unread Items ">
               <div class="panel panel-default"  style="border:1px solid gray;border-radius:10px">
                  <div class="panel-heading"  style="border:1px solid gray;border-radius:10px">Inbox</div>
                  <div class="panel-body" style="height: 480px;overflow: auto; position: relative">
                     <div class="row">
                        <div class="col-lg-2">
                           <span><asset:image src="1.png"  style="border:1px solid;border-radius: 15px;"/></span>
                        </div>
                        <div class="col-lg-10">
                           <div class="row">
                              <div class="col-lg-4">
                                 SagarMalShankhala
                              </div>
                              <div class="col-lg-3">@ sagar</div>
                              <div class="col-lg-2"> 5min</div>
                              <div class="col-lg-3">
                                 <span style="color:blue">Grails</span>
                              </div>
                           </div>
                           Lorem ipsum dolor sit amet,consectetur adipiscing   elit .Nulla quam velit,valputate eu pharetra nec,mattis ac neque. Duis<br>
                           <div class="row" >
                              <asset:image src="facebook.png"/>
                              <asset:image src="twtr.png"/>
                              <asset:image src="google.png"/>
                              <a href="#"><u>Download</u></a>
                              <a href="#"><u>View Full Size</u></a>
                              <a href="#"><u>Mark as Read</u></a>
                              <a href="#"><u>View Post</u></a>
                           </div>
                        </div>
                     </div>
                     <div class="row" style="border-top:1px solid gray;padding-top:10px">
                        <div class="col-lg-2">
                           <span><asset:image src="1.png"  style="border:1px solid;border-radius: 15px;"/></span>
                        </div>
                        <div class="col-lg-10">
                           <div class="row">
                              <div class="col-lg-4">
                                 SagarMalShankhala
                              </div>
                              <div class="col-lg-3">@ sagar</div>
                              <div class="col-lg-2"> 5min</div>
                              <div class="col-lg-3">
                                 <span style="color:blue">Grails</span>
                              </div>
                           </div>
                           Lorem ipsum dolor sit amet,consectetur adipiscing   elit .Nulla quam velit,valputate eu pharetra nec,mattis ac neque. Duis<br>
                           <div class="row">
                              <asset:image src="facebook.png"/>
                              <asset:image src="twtr.png"/>
                              <asset:image src="google.png"/>
                              <a href="#"><u>Download</u></a>
                              <a href="#"><u>View Full Size</u></a>
                              <a href="#"><u>Mark as Read</u></a>
                              <a href="#"><u>View Post</u></a>
                           </div>
                        </div>
                     </div>
                     <div class="row" style="border-top:1px solid gray;padding-top:10px">
                        <div class="col-lg-2">
                           <span><asset:image src="1.png"  style="border:1px solid;border-radius: 15px;"/></span>
                        </div>
                        <div class="col-lg-10">
                           <div class="row">
                              <div class="col-lg-4">
                                 SagarMalShankhala
                              </div>
                              <div class="col-lg-3">@ sagar</div>
                              <div class="col-lg-2"> 5min</div>
                              <div class="col-lg-3">
                                 <span style="color:blue">Grails</span>
                              </div>
                           </div>
                           Lorem ipsum dolor sit amet,consectetur adipiscing   elit .Nulla quam velit,valputate eu pharetra nec,mattis ac neque. Duis<br>
                           <div class="row">
                              <asset:image src="facebook.png"/>
                              <asset:image src="twtr.png"/>
                              <asset:image src="google.png"/>
                              <a href="#"><u>Download</u></a>
                              <a href="#"><u>View Full Size</u></a>
                              <a href="#"><u>Mark as Read</u></a>
                              <a href="#"><u>View Post</u></a>
                           </div>
                        </div>
                     </div>
                     <div class="row" style="border-top:1px solid gray;padding-top:10px">
                        <div class="col-lg-2">
                           <span><asset:image src="1.png"  style="border:1px solid;border-radius: 15px;"/></span>
                        </div>
                        <div class="col-lg-10">
                           <div class="row">
                              <div class="col-lg-4">
                                 SagarMalShankhala
                              </div>
                              <div class="col-lg-3">@ sagar</div>
                              <div class="col-lg-2"> 5min</div>
                              <div class="col-lg-3">
                                 <span style="color:blue">Grails</span>
                              </div>
                           </div>
                           Lorem ipsum dolor sit amet,consectetur adipiscing   elit .Nulla quam velit,valputate eu pharetra nec,mattis ac neque. Duis<br>
                           <div class="row">
                              <asset:image src="facebook.png"/>
                              <asset:image src="twtr.png"/>
                              <asset:image src="google.png"/>
                              <a href="#"><u>Download</u></a>
                              <a href="#"><u>View Full Size</u></a>
                              <a href="#"><u>Mark as Read</u></a>
                              <a href="#"><u>View Post</u></a>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
   <g:render template="../templates/DocumentResource/create"/>
   <g:render template="../templates/LinkResource/create"/>
   <g:render template="../templates/Topic/create"/>
      <g:render template="../templates/Topic/email"/>

</div>
</div>

</body>
</html>