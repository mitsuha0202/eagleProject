<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../admin/include/common.jsp" %>
<link rel="stylesheet" type="text/css" href="../eg/css/jquery.jqplot.css"/>
<link rel="stylesheet" href="../eg/css/jquery-ui.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
<style>
	.#chartArea{
		display:inline-block;	
	}
	
	.chart{
		display: inline-block;
	}
	#modal {display:none;background-color:#FFFFFF;position:absolute;top:200px;left:300px;padding:10px;border:2px solid #E2E2E2;z-Index:9999}
</style>

<title>Eagle 관리자페이지</title>
</head>
<body>
<div id="Wrap"><!-- Wrap S -->

	<%@ include file="include/header.jsp" %>

	<div id="container"><!-- container S -->

		<div class="tit">&bull; 통계보기</div>

		<div class="contBox mt30"><!-- contBox S -->			
			<p><h3>조회기간</h3>
			    <input type="text" id="datepicker1" style="height: 40px;"> ~
			    <input type="text" id="datepicker2" style="height: 40px;">
			    
			    <button class="ui button" onclick="dateSearch();" id="searchBtn">
				  	조회하기
				</button>
			</p>			
			<div class="tabBigBox btab_2ea mt40">
				<ul>
					<li style="width:33%"><a href="statList1.ad">카테고리별 통계</a></li>
					<li class="on" style="width:33%"><a href="statList2.ad">경매금액별 통계</a></li>
					<li class style="width:33%"><a href="statList3.sad">카테고리별 금액통계</a></li>
				</ul>
			</div>

			<div>
			</div>
			<div id=chartArea align="center" style="margin-top: 40px;">
			<div id="modal">
			    <div id="chart4" class="chart" style="width:500px;height:324px; margin-left: 20px;"></div>
			    <button class="js_close ui black basic button" style="font-weight: bold;">닫기</button>
			</div>
			<div id="chart" class="chart" style="width:500px;height:324px; margin-right: 30px;"></div>			
			<div id="chart1" class="chart" style="width:500px;height:324px;"></div>
			<div id="chart2" class="chart" style="width:500px;height:324px; margin-right: 30px; margin-top: 50px;"></div>
			<div id="chart3" class="chart" style="width:500px;height:324px; margin-top: 50px;"></div> 
			</div>
		</div><!--// contBox E-->

	</div><!--// container E-->

	<%@ include file="include/footer.jsp" %>


</div><!--// Wrap E-->

<script type="text/javascript" src="../eg/js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="../eg/js/jquery.jqplot.js"></script>
<script type="text/javascript" src="../eg/js/excanvas.js"></script>
<script type="text/javascript" src="../eg/js/plugins/jqplot.barRenderer.js"></script>
<script type="text/javascript" src="../eg/js/plugins/jqplot.categoryAxisRenderer.js"></script>
 <script src="../eg/js/jquery-ui.min.js"></script>
 <script type="text/javascript" src="../eg/js/Example.Modal.js"></script>
 <script>

	  
	// 모달 창 여는 버튼에 이벤트 걸기
	
	  
	// 모달 창 안에 있는 확인 버튼에 이벤트 걸기
	/* $("#confirm_button").click(function() {
	    alert("나는 모달창이다.");
	    myModal.hide(); // 모달창 감추기
	}); */
 jQuery(document).ready(function () {
		
		
	 $.ajax({
			url:"categoryPriceDays.sad",
			type:"get",
			dataType:"text",
			contentType : "application/json",
			success:function(data){
				var data = JSON.parse(data);
				console.log(data);
				var nameArr = new Array();
				var count = 0;
				var cateName = '';
				var cName = data.categoryName;
				var cCount = data.categoryCount
				
				
				var y = [];
				var x = [];
				
				for(var i=0; i<data.length; i++){
					y.push(data[i].priceCount);
					x.push(data[i].categoryName);
				}
			    jQuery("#chart").jqplot([y], {
			          title:"Days(단위:천)"
			        , seriesDefaults:{
			              renderer:jQuery.jqplot.BarRenderer
			            , rendererOptions:{
			                varyBarColor:true
			            }
			        }
			        , axes:{
			            xaxis:{
			                  renderer:jQuery.jqplot.CategoryAxisRenderer     
				                , ticks:['10이하','11~100','101~1,000','1,001~'] 
			            }
			        }
			    });
			},
			error:function(data){
				alert("에러");
			}
		});
	 
	 $.ajax({
			url:"categoryPriceWeek.sad",
			type:"get",
			dataType:"text",
			contentType : "application/json",
			success:function(data){
				var data = JSON.parse(data);
				console.log(data);
				var nameArr = new Array();
				var count = 0;
				var cateName = '';
				var cName = data.categoryName;
				var cCount = data.categoryCount
				
				
				var y = [];
				var x = [];
				
				for(var i=0; i<data.length; i++){
					y.push(data[i].priceCount);
					x.push(data[i].categoryName);
				}
			    jQuery("#chart1").jqplot([y], {
			          title:"Week(단위:천)"
			        , seriesDefaults:{
			              renderer:jQuery.jqplot.BarRenderer
			            , rendererOptions:{
			                varyBarColor:true
			            }
			        }
			        , axes:{
			            xaxis:{
			                  renderer:jQuery.jqplot.CategoryAxisRenderer     
				                , ticks:['10이하','11~100','101~1,000','1,001~'] 
			            }
			        }
			    });
			},
			error:function(data){
				alert("에러");
			}
		});
	 
	 $.ajax({
			url:"categoryPriceMonth.sad",
			type:"get",
			dataType:"text",
			contentType : "application/json",
			success:function(data){
				var data = JSON.parse(data);
				console.log(data);
				var nameArr = new Array();
				var count = 0;
				var cateName = '';
				var cName = data.categoryName;
				var cCount = data.categoryCount
				
				
				var y = [];
				var x = [];
				
				for(var i=0; i<data.length; i++){
					y.push(data[i].priceCount);
					x.push(data[i].categoryName);
				}
			    jQuery("#chart2").jqplot([y], {
			          title:"Month(단위:천)"
			        , seriesDefaults:{
			              renderer:jQuery.jqplot.BarRenderer
			            , rendererOptions:{
			                varyBarColor:true
			            }
			        }
			        , axes:{
			            xaxis:{
			                  renderer:jQuery.jqplot.CategoryAxisRenderer     
				                , ticks:['10이하','11~100','101~1,000','1,001~'] 
			            }
			        }
			    });
			},
			error:function(data){
				alert("에러");
			}
		});
	 
	 
	 $.ajax({
			url:"categoryPriceYear.sad",
			type:"get",
			dataType:"text",
			contentType : "application/json",
			success:function(data){
				var data = JSON.parse(data);
				console.log(data);
				var nameArr = new Array();
				var count = 0;
				var cateName = '';
				var cName = data.categoryName;
				var cCount = data.categoryCount
				
				
				var y = [];
				var x = [];
				
				for(var i=0; i<data.length; i++){
					y.push(data[i].priceCount);
					x.push(data[i].categoryName);
				}
			    jQuery("#chart3").jqplot([y], {
			          title:"Year(단위:천)"
			        , seriesDefaults:{
			              renderer:jQuery.jqplot.BarRenderer
			            , rendererOptions:{
			                varyBarColor:true
			            }
			        }
			        , axes:{
			            xaxis:{
			                  renderer:jQuery.jqplot.CategoryAxisRenderer     
				                , ticks:['10이하','11~100','101~1,000','1,001~'] 
			            }
			        }
			    });
			},
			error:function(data){
				alert("에러");
			}
		});
 });
 
 function dateSearch() {
	 
		var datepicker1 = $("#datepicker1").val();
		var datepicker2 = $("#datepicker2").val();
		if(datepicker1 == "" || datepicker2 == ""){
			alert('기간을 정확히 설정해주세요.\n(하루일 경우도 설정해줘야합니다.ex)2019-03-07~2019-03-07)');

		}else{
			var myModal = new Example.Modal({
			    id: 'modal'
			});
			$("#searchBtn").click(function() {
			    myModal.show(); // 모달창 보여주기
			});
		
			console.log(datepicker1);
			console.log(datepicker2);
			$.ajax({
				url:"priceDaySearch.sad",
				type:"get",
				data:{datepicker1:datepicker1, datepicker2:datepicker2},
				dataType:"text",
				contentType : "application/json",
				success:function(data){
					var data = JSON.parse(data);
					console.log(data);
					var nameArr = new Array();
					var count = 0;
					var cateName = '';
					var cName = data.categoryName;
					var cCount = data.categoryCount
					
					
					var y = [];
					var x = [];
					
					for(var i=0; i<data.length; i++){
						y.push(data[i].priceCount);
						x.push(data[i].categoryName);
					}
				    jQuery("#chart4").jqplot([y], {
				          title:datepicker1+"~"+datepicker2+"(단위:천)"
				        , seriesDefaults:{
				              renderer:jQuery.jqplot.BarRenderer
				            , rendererOptions:{
				                varyBarColor:true
				            }
				        }
				        , axes:{
				            xaxis:{
				                  renderer:jQuery.jqplot.CategoryAxisRenderer     
					                , ticks:['10이하','11~100','101~1,000','1,001~'] 
				            }
				        }
				    });
				},
				error:function(data){
					alert("에러");
				}
			}); 
		}
	}
 
 </script>
 
 <script>
jQuery.browser = {};
(function () {
    jQuery.browser.msie = false;
    jQuery.browser.version = 0;
    if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
        jQuery.browser.msie = true;
        jQuery.browser.version = RegExp.$1;
    }
})();
    $(function() {
        $("#datepicker1, #datepicker2").datepicker({
            dateFormat: 'yy-mm-dd'
            ,changeYear: true //콤보박스에서 년 선택 가능
            ,changeMonth: true //콤보박스에서 월 선택 가능    
        });
    });

</script>

</body>
</html>