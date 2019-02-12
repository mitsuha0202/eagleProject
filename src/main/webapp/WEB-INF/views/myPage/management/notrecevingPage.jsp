<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>미수령신고</title>
</head>
<style>
      /* 구매현황 테이블 div */
	.buyStatus{
		position: absolute;
		left: 70px;
		top: 515px;
	}
	/* 구매현황 테이블, 판매현황 테이블 */
	.buyStatusTable, tr, td{
		border: 1px solid black;
		text-align: center;
		width: 1355px;
		height: 50px;
	}
	/* 테이블 맨윗줄 선 */
	.firstTd{
		border-top: 3.5px solid #205181;
	}
	
	/* 물품검색 조회리스트 */
	.resultitemlist{
		border: 1px solid #bcbcbc;
	}
	.tutorialDiv{
		background-color: lightgray;
		position: absolute;
		left: 70px;
		top: 1020px;
		width: 1355px;
		height: 200px;
	}
	.tutorialText1{
		position: absolute;
		top: 30px;
		left: 100px;
	}
	.tutorialText2{
		position: absolute;
		top: 70px;
		left: 100px;
	}
	.tutorialText3{
		position: absolute;
		left: 280px;
		
	}
	.tutorialText4{
		position: absolute;
		top: 120px;
		left: 100px;
	}
	.tutorialIcon1{
		position: absolute;
		top: 140px;
		left: 850px;	
	}
	.tutorialIcon2{
		position: absolute;
		top: 140px;
		left: 1100px;	
	}
</style>
<body>
	<!-- 헤더바 -->
	<jsp:include page="../../common/header.jsp"/>
	
	<!-- 헤더바 밑 선 -->
	<hr class="firstLine">
	<h1>구매관리(구매거부/반품/미입금/판매거부/미수령신고)</h1>
    <div class="buyStatus">
		<table class="buyStatusTable">
			<tr>
				<td class="firstTd" onclick="location.href='purchasestatus.mp'">입찰중물품</td>
				<td class="firstTd" onclick="location.href='purchaseend.mp'" colspan="1">구매 종료</td>
				<td class="firstTd" onclick="location.href='purchaseitemdeal.mp'" >구매 물품 거래 진행중</td>
				<td class="firstTd" onclick="location.href='purchaseother.mp'" colspan="3">구매거부/반품/미입금/판매거부/미수령신고</td>
			</tr>			
			<tr>
				<td><h5>물품상태</h5></td>
				<!-- td태그 오른쪽 선 안보이게 하기  -->
				<td style="border-right: hidden;" onclick="location.href='purchaseother.mp'"><h5>구매거부</h5></td>
				<td style="border-right: hidden;" onclick="location.href='return.mp'"><h5>반품</h5></td>
				<td style="border-right: hidden;" onclick="location.href='payment.mp'"><h5>미입금</h5></td>
				<td style="border-right: hidden;" onclick="location.href='refusetosell.mp'"><h5>판매거부</h5></td>
				<td onclick="location.href='notreceving.mp'"><h5>미수령신고</h5></td>
			</tr>
			
			
		</table>
		
		 <h5>꼭 읽어주세요! </h5><br>
	     <h5>현재 입찰하신 물품중 미수령신고 물품 리스트입니다.</h5>
	     <br>
	     <h5>미수령신고 물품에 대해서 모두</h5><h5>개가 검색되었습니다.</h5>
	     
	     <table class="buyStatusTable">
      
      <thead>
        <tr>
          <th class="firstTd">물품번호</th>
          <th class="firstTd">이미지</th>
          <th class="firstTd">물품명</th>
          <th class="firstTd">금액정보</th>
          <th class="firstTd">판매자</th>
          <th class="firstTd">현재상태</th>
          <th class="firstTd">처리현황</th>
          <th class="firstTd">날짜정보</th>
          <th class="firstTd">관리</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          
        </tr>
       
        
      </tbody>
     
    </table>
	     
	</div>
	
	<!-- 하단 div영역 -->
	<div class="tutorialDiv">
		<br>
		<h4 class="tutorialText1">고객센터 상담전화</h4>
		<br><br>
		<h4 class="tutorialText2">02-000-0000</h4>
		<h4 class="tutorialText3">평일 09:00~18:00</h4>&nbsp;<h4 class="tutorialText3">점심 12:00~13:00</h4>
		<h4 class="tutorialText4">토 일 공휴일 휴무</h4>
		<i class="clipboard icon" id="auctionInfo" onclick="location.href='egAuctionInfo.mp'"></i>
		<h4 class="tutorialIcon1" onclick="egAuctionInfo.mp">사이트이용안내</h4>
		<i class="dollar sign icon" id="accountInfo"></i>
		<h4 class="tutorialIcon2">자주묻는 질문</h4>		
	</div>
</body>
</html>