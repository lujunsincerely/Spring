<%--
  Created by IntelliJ IDEA.
  User: twx
  Date: 2017/3/19
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="http://hayageek.github.io/jQuery-Upload-File/4.0.10/uploadfile.css" rel="stylesheet">
    <link href="//cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.min.css" rel="stylesheet">

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="http://hayageek.github.io/jQuery-Upload-File/4.0.10/jquery.uploadfile.min.js"></script>
    <script src="http://apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>


</head>
<body>
    <div id="file">Upload</div>

    <div id="progressbar">
        <div class="progress-label">.</div>
    </div>
    <br>
    <button id="getTest" name="getTest">Button</button>

    <script>
        $(document).ready(function()
        {
            $("#file").uploadFile({
                url:"/receive",
                method:"POST",
                dragDrop:false,
                fileName:"file",
                onSuccess:function(files,data,xhr,pd){
                    alert("OK"+data)
                },
                onError: function(){
                    alert("error")
                }
            });

            var progressbar = $( "#progressbar" ),
                progressLabel = $( ".progress-label" );

            progressbar.progressbar({
                value: false,
                max:1000,
                change: function() {
                    progressLabel.text( progressbar.progressbar( "value" ));
                },
                complete: function() {
                    progressLabel.text( "完成！" );
                }
            });


            $('#getTest').on('click',function () {
                $.get("/get1",function (data, status) {
                    console.log(data)
                });


                var flag = setInterval(function () {
                    $.get("/get2",function (data, status) {
                        progressbar.progressbar( "value",parseInt(data) );
                        if(data=="1000") {
                            clearInterval(flag);
                        }
                    });
                }, 1000);
            });


        });
    </script>
</body>
</html>
