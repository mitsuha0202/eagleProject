<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../admin/include/common.jsp" %>
<link rel="stylesheet" type="text/css" href="../eg/css/jquery.jqplot.css"/>
<style>
	.#chartArea{
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
						
			<div class="tabBigBox btab_2ea mt40">
				<ul>
					<li class="on"><a href="statList1.ad">카테고리별 통계</a></li>
					<li><a href="statList2.ad">경매금액별 통계</a></li>
				</ul>
			</div>
			<div>
			</div>
			<div id=chartArea align="center" style="margin-top: 40px;">
			<div id="chart" class="chart" style="width:500px;height:324px; margin-right: 30px;"></div>
			
			<!-- <div id="chart1" class="chart" style="width:500px;height:324px;"></div>
			<div id="chart2" class="chart" style="width:500px;height:324px; margin-right: 30px; margin-top: 50px;"></div>
			<div id="chart3" class="chart" style="width:500px;height:324px; margin-top: 50px;"></div> -->
			</div>
		</div><!--// contBox E-->

	</div><!--// container E-->

	<%@ include file="include/footer.jsp" %>


</div><!--// Wrap E-->

<script type="text/javascript" src="../eg/js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="../eg/js/jquery.jqplot.js"></script>
<script type="text/javascript" src="../eg/js/jquery.excanvas.js"></script>
<script type="text/javascript" src="../eg/js/plugins/jqplot.barRenderer.js"></script>
<script type="text/javascript" src="../eg/js/plugins/jqplot.categoryAxisRenderer.js"></script>

<script type="text/javascript">
jQuery(document).ready(function () {
	
	
 	$.ajax({
		url:"categoryDays.sad",
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
		          title:"일일"
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
  /*   var line = [6, 5, 2, 4, 6, 6, 4];
    jQuery("#chart").jqplot([line], {
          title:"일일"
        , seriesDefaults:{
              renderer:jQuery.jqplot.BarRenderer
            , rendererOptions:{
                varyBarColor:true
            }
        }
        , axes:{
            xaxis:{
                  renderer:jQuery.jqplot.CategoryAxisRenderer

                , ticks:['미술', '음악앨범', '의류', '생활가전', '비디오게임','피규어','레고']

            }
        }
    });
}); */

/* jQuery(document).ready(function () {
    var line = [6, 5, 2, 4, 6, 6, 4];
    jQuery("#chart1").jqplot([line], {
          title:"주간"
        , seriesDefaults:{
              renderer:jQuery.jqplot.BarRenderer
            , rendererOptions:{
                varyBarColor:true
            }
        }
        , axes:{
            xaxis:{
                  renderer:jQuery.jqplot.CategoryAxisRenderer

                , ticks:['미술', '음악앨범', '의류', '생활가전', '비디오게임','피규어','레고']

            }
        }
    });
});

jQuery(document).ready(function () {
    var line = [6, 5, 2, 4, 6, 6, 4];
    jQuery("#chart2").jqplot([line], {
          title:"월간"
        , seriesDefaults:{
              renderer:jQuery.jqplot.BarRenderer
            , rendererOptions:{
                varyBarColor:true
            }
        }
        , axes:{
            xaxis:{
                  renderer:jQuery.jqplot.CategoryAxisRenderer

                , ticks:['미술', '음악앨범', '의류', '생활가전', '비디오게임','피규어','레고']

            }
        }
    });
});

jQuery(document).ready(function () {
    var line = [6, 5, 2, 4, 6, 6, 4];
    jQuery("#chart3").jqplot([line], {
          title:"연별"
        , seriesDefaults:{
              renderer:jQuery.jqplot.BarRenderer
            , rendererOptions:{
                varyBarColor:true
            }
        }
        , axes:{
            xaxis:{
                  renderer:jQuery.jqplot.CategoryAxisRenderer

                , ticks:['미술', '음악앨범', '의류', '생활가전', '비디오게임','피규어','레고']

            }
        }
    });
}); */

</script>




</body>
</html>