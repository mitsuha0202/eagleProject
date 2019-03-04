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
	.chartArea{
		display:inline-block;	
	}
	
	.chart{
		display: inline-block;
	}
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
			    
			    <button class="ui button" onclick="dateSearch();">
				  	조회하기
				</button>
			</p>
			
			<div class="tabBigBox btab_2ea mt40">
				<ul>
					<li style="width:33%"><a href="statList1.ad">카테고리별 통계</a></li>
					<li style="width:33%"><a href="statList2.ad">경매금액별 통계</a></li>
					<li class="on" style="width:33%"><a href="statList3.sad">카테고리별 금액통계</a></li>
					
				</ul>
			</div>
			<div>
			</div>
			<h2 align="center"> Days </h2>
			<div class=chartArea align="center" style="margin-top: 40px;">
			<div id="chart" class="chart" style="width:500px;height:324px; margin-right: 30px;"></div>
			
			<div id="chart1" class="chart" style="width:500px;height:324px;"></div>
			 <div id="chart2" class="chart" style="width:500px;height:324px; margin-right: 30px; margin-top: 50px;"></div>
			<div id="chart3" class="chart" style="width:500px;height:324px; margin-top: 50px;"></div> 
			</div>
			
			<div class="ui divider"></div>
			
			<h2 align="center"> Week </h2>
			<div class=chartArea align="center" style="margin-top: 40px;">
			<div id="chart4" class="chart" style="width:500px;height:324px; margin-right: 30px;"></div>
			
			<div id="chart5" class="chart" style="width:500px;height:324px;"></div>
			 <div id="chart6" class="chart" style="width:500px;height:324px; margin-right: 30px; margin-top: 50px;"></div>
			<div id="chart7" class="chart" style="width:500px;height:324px; margin-top: 50px;"></div> 
			</div>
			
			<div class="ui divider"></div>
			
			<h2 align="center"> Month </h2>
			<div class=chartArea align="center" style="margin-top: 40px;">
			<div id="chart8" class="chart" style="width:500px;height:324px; margin-right: 30px;"></div>
			
			<div id="chart9" class="chart" style="width:500px;height:324px;"></div>
			 <div id="chart10" class="chart" style="width:500px;height:324px; margin-right: 30px; margin-top: 50px;"></div>
			<div id="chart11" class="chart" style="width:500px;height:324px; margin-top: 50px;"></div> 
			</div>
			
			<div class="ui divider"></div>
			
			<h2 align="center"> Year </h2>
			<div class=chartArea align="center" style="margin-top: 40px;">
			<div id="chart12" class="chart" style="width:500px;height:324px; margin-right: 30px;"></div>
			
			<div id="chart13" class="chart" style="width:500px;height:324px;"></div>
			 <div id="chart14" class="chart" style="width:500px;height:324px; margin-right: 30px; margin-top: 50px;"></div>
			<div id="chart15" class="chart" style="width:500px;height:324px; margin-top: 50px;"></div> 
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
<script type="text/javascript">
jQuery(document).ready(function () {
	
	
 	$.ajax({
		url:"lastCateDaysTen.sad",
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
				y.push(data[i].categoryCount);
				x.push(data[i].categoryName);
			}
		    jQuery("#chart").jqplot([y], {
		          title:"10,000원 이하"
		        , seriesDefaults:{
		              renderer:jQuery.jqplot.BarRenderer
		            , rendererOptions:{
		                varyBarColor:true
		            }
		        }
		        , axes:{
		            xaxis:{
		                  renderer:jQuery.jqplot.CategoryAxisRenderer     
			                , ticks:x 
		            }
		        }
		    });
		},
		error:function(data){
			alert("에러");
		}
	}); 

  
    $.ajax({
	url:"lastCateDaysHun.sad",
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
			y.push(data[i].categoryCount);
			x.push(data[i].categoryName);
		}
	    jQuery("#chart1").jqplot([y], {
	          title:"10,001원 ~ 100,000원 이하"
	        , seriesDefaults:{
	              renderer:jQuery.jqplot.BarRenderer
	            , rendererOptions:{
	                varyBarColor:true
	            }
	        }
	        , axes:{
	            xaxis:{
	                  renderer:jQuery.jqplot.CategoryAxisRenderer     
		                , ticks:x 
	            }
	        }
	    });
	},
	error:function(data){
		alert("에러");
	}
});  

	
 	$.ajax({
		url:"lastCateDaysMil.sad",
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
				y.push(data[i].categoryCount);
				x.push(data[i].categoryName);
			}
		    jQuery("#chart2").jqplot([y], {
		          title:"100,001원 ~ 1,000,000원 이하"
		        , seriesDefaults:{
		              renderer:jQuery.jqplot.BarRenderer
		            , rendererOptions:{
		                varyBarColor:true,
		            }
		        }
		        , axes:{
		            xaxis:{
		                  renderer:jQuery.jqplot.CategoryAxisRenderer     
			                , ticks:x 
		            }
		        }
		    });
		},
		error:function(data){
			alert("에러");
		}
	});  

  $.ajax({
		url:"lastCateDaysMax.sad",
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
				y.push(data[i].categoryCount);
				x.push(data[i].categoryName);
			}
		    jQuery("#chart3").jqplot([y], {
		          title:"1,000,001원 이상"
		        , seriesDefaults:{
		              renderer:jQuery.jqplot.BarRenderer
		            , rendererOptions:{
		                varyBarColor:true
		            }
		        }
		        , axes:{
		            xaxis:{
		                  renderer:jQuery.jqplot.CategoryAxisRenderer     
			                , ticks:x 
		            }
		        }
		    });
		},
		error:function(data){
			alert("에러");
		}
	});
  
  /* Day 카테고리 금액별 통계 종료 */
  
  $.ajax({
		url:"lastCateWeekTen.sad",
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
				y.push(data[i].categoryCount);
				x.push(data[i].categoryName);
			}
		    jQuery("#chart4").jqplot([y], {
		          title:"10,000원 이하"
		        , seriesDefaults:{
		              renderer:jQuery.jqplot.BarRenderer
		            , rendererOptions:{
		                varyBarColor:true
		            }
		        }
		        , axes:{
		            xaxis:{
		                  renderer:jQuery.jqplot.CategoryAxisRenderer     
			                , ticks:x 
		            }
		        }
		    });
		},
		error:function(data){
			alert("에러");
		}
	}); 


  $.ajax({
	url:"lastCateWeekHun.sad",
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
			y.push(data[i].categoryCount);
			x.push(data[i].categoryName);
		}
	    jQuery("#chart5").jqplot([y], {
	          title:"10,001원 ~ 100,000원 이하"
	        , seriesDefaults:{
	              renderer:jQuery.jqplot.BarRenderer
	            , rendererOptions:{
	                varyBarColor:true
	            }
	        }
	        , axes:{
	            xaxis:{
	                  renderer:jQuery.jqplot.CategoryAxisRenderer     
		                , ticks:x 
	            }
	        }
	    });
	},
	error:function(data){
		alert("에러");
	}
});  

	
	$.ajax({
		url:"lastCateWeekMil.sad",
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
				y.push(data[i].categoryCount);
				x.push(data[i].categoryName);
			}
		    jQuery("#chart6").jqplot([y], {
		          title:"100,001원 ~ 1,000,000원 이하"
		        , seriesDefaults:{
		              renderer:jQuery.jqplot.BarRenderer
		            , rendererOptions:{
		                varyBarColor:true,
		            }
		        }
		        , axes:{
		            xaxis:{
		                  renderer:jQuery.jqplot.CategoryAxisRenderer     
			                , ticks:x 
		            }
		        }
		    });
		},
		error:function(data){
			alert("에러");
		}
	});  

$.ajax({
		url:"lastCateWeekMax.sad",
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
				y.push(data[i].categoryCount);
				x.push(data[i].categoryName);
			}
		    jQuery("#chart7").jqplot([y], {
		          title:"1,000,001원 이상"
		        , seriesDefaults:{
		              renderer:jQuery.jqplot.BarRenderer
		            , rendererOptions:{
		                varyBarColor:true
		            }
		        }
		        , axes:{
		            xaxis:{
		                  renderer:jQuery.jqplot.CategoryAxisRenderer     
			                , ticks:x 
		            }
		        }
		    });
		},
		error:function(data){
			alert("에러");
		}
	});
/* Week 카테고리 금액별 통계 종료 */
 
$.ajax({
	url:"lastCateMonthTen.sad",
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
			y.push(data[i].categoryCount);
			x.push(data[i].categoryName);
		}
	    jQuery("#chart8").jqplot([y], {
	          title:"10,000원 이하"
	        , seriesDefaults:{
	              renderer:jQuery.jqplot.BarRenderer
	            , rendererOptions:{
	                varyBarColor:true
	            }
	        }
	        , axes:{
	            xaxis:{
	                  renderer:jQuery.jqplot.CategoryAxisRenderer     
		                , ticks:x 
	            }
	        }
	    });
	},
	error:function(data){
		alert("에러");
	}
}); 


$.ajax({
url:"lastCateMonthHun.sad",
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
		y.push(data[i].categoryCount);
		x.push(data[i].categoryName);
	}
    jQuery("#chart9").jqplot([y], {
          title:"10,001원 ~ 100,000원 이하"
        , seriesDefaults:{
              renderer:jQuery.jqplot.BarRenderer
            , rendererOptions:{
                varyBarColor:true
            }
        }
        , axes:{
            xaxis:{
                  renderer:jQuery.jqplot.CategoryAxisRenderer     
	                , ticks:x 
            }
        }
    });
},
error:function(data){
	alert("에러");
}
});  


$.ajax({
	url:"lastCateMonthMil.sad",
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
			y.push(data[i].categoryCount);
			x.push(data[i].categoryName);
		}
	    jQuery("#chart10").jqplot([y], {
	          title:"100,001원 ~ 1,000,000원 이하"
	        , seriesDefaults:{
	              renderer:jQuery.jqplot.BarRenderer
	            , rendererOptions:{
	                varyBarColor:true,
	            }
	        }
	        , axes:{
	            xaxis:{
	                  renderer:jQuery.jqplot.CategoryAxisRenderer     
		                , ticks:x 
	            }
	        }
	    });
	},
	error:function(data){
		alert("에러");
	}
});  

$.ajax({
	url:"lastCateMonthMax.sad",
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
			y.push(data[i].categoryCount);
			x.push(data[i].categoryName);
		}
	    jQuery("#chart11").jqplot([y], {
	          title:"1,000,001원 이상"
	        , seriesDefaults:{
	              renderer:jQuery.jqplot.BarRenderer
	            , rendererOptions:{
	                varyBarColor:true
	            }
	        }
	        , axes:{
	            xaxis:{
	                  renderer:jQuery.jqplot.CategoryAxisRenderer     
		                , ticks:x 
	            }
	        }
	    });
	},
	error:function(data){
		alert("에러");
	}
});
/* Month 카테고리 금액별 통계 종료 */
$.ajax({
	url:"lastCateYearTen.sad",
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
			y.push(data[i].categoryCount);
			x.push(data[i].categoryName);
		}
	    jQuery("#chart12").jqplot([y], {
	          title:"10,000원 이하"
	        , seriesDefaults:{
	              renderer:jQuery.jqplot.BarRenderer
	            , rendererOptions:{
	                varyBarColor:true
	            }
	        }
	        , axes:{
	            xaxis:{
	                  renderer:jQuery.jqplot.CategoryAxisRenderer     
		                , ticks:x 
	            }
	        }
	    });
	},
	error:function(data){
		alert("에러");
	}
}); 


$.ajax({
url:"lastCateYearHun.sad",
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
		y.push(data[i].categoryCount);
		x.push(data[i].categoryName);
	}
    jQuery("#chart13").jqplot([y], {
          title:"10,001원 ~ 100,000원 이하"
        , seriesDefaults:{
              renderer:jQuery.jqplot.BarRenderer
            , rendererOptions:{
                varyBarColor:true
            }
        }
        , axes:{
            xaxis:{
                  renderer:jQuery.jqplot.CategoryAxisRenderer     
	                , ticks:x 
            }
        }
    });
},
error:function(data){
	alert("에러");
}
});  


$.ajax({
	url:"lastCateYearMil.sad",
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
			y.push(data[i].categoryCount);
			x.push(data[i].categoryName);
		}
	    jQuery("#chart14").jqplot([y], {
	          title:"100,001원 ~ 1,000,000원 이하"
	        , seriesDefaults:{
	              renderer:jQuery.jqplot.BarRenderer
	            , rendererOptions:{
	                varyBarColor:true,
	            }
	        }
	        , axes:{
	            xaxis:{
	                  renderer:jQuery.jqplot.CategoryAxisRenderer     
		                , ticks:x 
	            }
	        }
	    });
	},
	error:function(data){
		alert("에러");
	}
});  

$.ajax({
	url:"lastCateYearMax.sad",
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
			y.push(data[i].categoryCount);
			x.push(data[i].categoryName);
		}
	    jQuery("#chart15").jqplot([y], {
	          title:"1,000,001원 이상"
	        , seriesDefaults:{
	              renderer:jQuery.jqplot.BarRenderer
	            , rendererOptions:{
	                varyBarColor:true
	            }
	        }
	        , axes:{
	            xaxis:{
	                  renderer:jQuery.jqplot.CategoryAxisRenderer     
		                , ticks:x 
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
			console.log(datepicker1);
			console.log(datepicker2);
			$.ajax({
				url:"categoryDaySearch.sad",
				type:"get",
				data:{datepicker1:datepicker1, datepicker2:datepicker2},
				dataType:"JSON",
				contentType : "application/json",
				success:function(data){
					alert("성공");
				},
				error:function(data){
					alert("에러");
				}
			}); 
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
        });
    });

</script>



</body>
</html>