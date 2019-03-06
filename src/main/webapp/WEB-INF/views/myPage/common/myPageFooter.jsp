<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <!-- jquery -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
   
   
   <style>
   @media screen and (max-width : 1024px) {
         footer {
            display : none;
         }
    }
   #footer {
     height : 40px;
      background-color : rgba(228, 228, 228, 0.589);
      border-top : 0.1px solid rgba(190, 188, 190, 1);
     
   }
   
   .not_hover_stl{  /* a태 */
      color : gray;
      float:left;
   }
   
   .not_hover_stl:hover {
      color: gray;
   }
   
   .foot-a{
      text-decoration : none;
      margin : 2px 15px;
      font-size : 12px;
      color:gray;
      cursor: pointer;
   }
   
   .first {
      margin-left : 13%;
   }
   
   .txt_com_login{
      margin-top: 8px;
      margin-left: 38%;
      font-size : 12px;
      color : gray;
   }
   
   .txt_com_login:hover{
      text-decoration : none;
      color : gray;
   }
   
   /* .left-container {
      height: 30pxx;
   } */
   
   </style>
</head>

<body>
   <div class = "left-container"></div>
   <!-- footer 시작 -->
   <footer> 
      <div>
         <a class = "foot-a first not_hover_stl" style ="font-weight:bold; color : gray; font-size: large;" >Eagle's Auction</a>
         <a class = "foot-a not_hover_stl" style="font-size: large; color : gray;" >제휴문의</a> <p class = "not_hover_stl" style="font-size: large; color : gray;"> | </p>
         <a class = "foot-a not_hover_stl" style="font-size: large; color : gray;">개인정보 취급방침  </a> <p class = "not_hover_stl" style="font-size: large; color : gray;"> | </p>
         <a class = "foot-a not_hover_stl" id = "customer_center" style="font-size: large; color : gray;"> 고객센터</a>  <p class = "not_hover_stl" style="font-size: large; color : gray;"> |  </p>
         <a class = "foot-a not_hover_stl" style="font-size: large; color : gray;" >이용약관 </a> <p class = "not_hover_stl" style="font-size: large; color : gray;"> |  </p>
         <a class = "foot-a not_hover_stl" onclick="location.href='queryBoard.mp'" style="font-size: large; color : gray;">문의게시판</a><p class = "not_hover_stl" style="font-size: large; color : gray;"> |  </p>
         <a class = "foot-a not_hover_stl" onclick="location.href='answerBoard.mp'"style="font-size: large; color : gray;" >문의받은게시판</a><p class = "not_hover_stl" style="font-size: large; color : gray;"> |  </p>
         <a class = "foot-a not_hover_stl" onclick="location.href='egAuctionInfo.mp'" style="font-size: large; color : gray;">사이트이용안내</a>   
      </div>
      <br>
      <p class = "foot-a first"> Copyright Eagle's Company. All rights reserved.  </p>
    </footer>
    <!-- footer 끝 -->
    
    <script>
    $("#customer_center").click(function () {
          alert("고객센터 080-1234-1234로 연락바랍니다.");
    });
    </script>
    
</body>
</html>