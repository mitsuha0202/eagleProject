<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사이트 이용안내</title>
<style>
	/* 페이지 제목 */
	.title{
		position: absolute;
		left: 70px;
		top: 200px;
	}
	/* 페이지 제목 밑 선 */
	.firstLine{
		border: 1px solid #205181;
	}
	.closeBtn{
		position: absolute;
		top: 1050px;
		left: 680px;
		text-align: center;
		background-color: white;
		border: 1px solid #205181;
		color:#205181;
		border-radius: 10px;
		width: 150px;
		height: 40px;
	    font-size: 16px;
	}
</style>
</head>
<body>
	<!-- 헤더바 -->
	<jsp:include page="../common/header.jsp"/>
	
	<!-- 헤더바 밑 선 -->
	<hr class="firstLine">
	<table class="ui single line table">
  <thead>
    <tr>
      <th>Eagle's Auction Guide</th>
      
    </tr>
  </thead>
  
</table>
<table class="ui single line table">
  <thead>
    <tr>
      <th>Eagle's Auction이 처음이신가요?</th>
      
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><h5>모든 구매자와 판매자에게 열려있는 오픈마켓, 코베이옥션! 당신을 환영합니다.<br>더 이상 헤매지 마십시오. 코베이옥션에 다 있습니다.</h5></td>
      
    </tr>
   
  </tbody>
</table>
<table class="ui single line table">
  <thead>
    <tr>
      <th>Eagle's Auction을 이용하시기 전 꼭! 확인해주세요.</th>
      
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><h5>코베이옥션을 이용하시려면 먼저 회원가입이 필요합니다.<br>
			위조, 가짜, 법령상 판매가 제한 또는 금지된 품목은 등록할 수 없습니다.<br>
			과대광고, 허위사실을 기재할 수 없습니다.<br>
			정상적인 거래완료 후, 구매/판매 수수료 공제 후 송금됩니다.<br>
			품목 별 수수료가 상이합니다.<br> 
			코베이옥션은 가격을 올리기 위한 불법행위를 엄격히 제한 및 관리하고 있습니다.<br>
			코베이옥션의 모든 거래는 매매보호서비스를 통해 안전하게 거래되어 반품, 교환, 환불이 가능합니다.<br>
			코베이옥션 입찰방식은 3가지로 나뉘어 집니다.<br>
			- 최고가 밀봉경매 : 밀봉경매란 입찰가를 다른 입찰자들이 볼 수 없고 입찰자들은 입찰가를 제출하여 가장 높은 가격을 적은 입찰자가 경매에 입찰되는 방식<br>
			- 다운경매 : 상한가를 정해놓고 계속해서 낮은가격을 불러 매수인이 그 낮은 가격을 인정해야 하거나 너무 낮아 매물을 회수해야 할 지경에 이를때까지 경매가를 낮추는 방법<br> 
			- 행운경매 : 랜덤추출 낙찰방식은 다음의 네 가지 원칙에 의해서 낙찰자를 결정(단, 낙찰범위 설정을 위해 기본 금액을 입력하여야함)<br>
			첫째, 낙찰범위 가운데에서 임의의 한 가격이 낙찰가격으로 결정<br>
			둘째, 결정된 낙찰가격에 입찰자가 없을 경우 결정된 낙찰가격보다 높은 가격 중에서 가장 가까운 가격을 낙찰가격으로 결정<br>
			셋째, 결정된 낙찰가격에 입찰한 사람이 여러 명일 경우에는 가장 먼저 입찰한 사람을 낙찰자로 결정<br>
			넷째, 낙찰자가 구매를 포기하더라도 다음 사람에게 낙찰이 인계되지 않음</h5><br></td>
      
    </tr>
   
  </tbody>
</table>
<table class="ui single line table">
  <thead>
    <tr>
      <th>온라인 경매 시작하기전 꼭! 확인해주세요.</th>
      
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><h5>- 입찰취소는 불가하니 신중한 입찰 부탁 드립니다.<br>
			- 코베이옥션의 모든 거래는 매매보호서비스를 통해 안전하게 거래되어 반품, 교환, 환불이 가능합니다.<br>
			- [입금신청]시 작성하신 입금 신청서와 동일한 정보로 입금해주시면 더 빨리 물건을 받아보실 수 있습니다.<br>
			- 코베이옥션 입찰방식은 가장 높은 입찰금액을 제시한 사람에게 낙찰(판매)됩니다.<br>
			-  등록할 물품의 카테고리를 정확하게 분류하는 것은 높은 낙찰가와 빠른 판매를 돕는 지름길 입니다.<br>
			- 물품의 원산지를 꼭 기입해주셔야 합니다.<br>
			- 직거래를 위한 판매자 정보 노출은 불가 합니다. (직거래,가격흥정 피해)</h5><br>	</td>
      
    </tr>
    
  </tbody>
</table>
	
	<button class="closeBtn" onclick="location.href='myPageMain.mp'">닫기</button>
	
	
</body>
</html>