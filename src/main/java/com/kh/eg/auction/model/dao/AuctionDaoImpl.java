package com.kh.eg.auction.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.eg.attachment.model.vo.Attachment;
import com.kh.eg.bidding.model.vo.Bid;
import com.kh.eg.category.model.vo.Category;
import com.kh.eg.item.model.vo.Item;
import com.kh.eg.member.model.vo.Member;



@Repository
public class AuctionDaoImpl implements AuctionDao {

	@Override
	public ArrayList<Attachment> selectAttachment(SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("Item.selectAttachment");
	}

	@Override
	public ArrayList<Bid> selectBid(SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("Item.selectBid");
	}

	@Override
	public ArrayList<Item> selectItem(SqlSessionTemplate sqlSession) {
		
		return (ArrayList)sqlSession.selectList("Item.selectItem");
	}

	@Override
	public ArrayList<Bid> selectBid(SqlSessionTemplate sqlSession, String alignName) {
		
		ArrayList<Bid> bidlist=null;
		if(alignName.equals("1")) {
			bidlist=(ArrayList)sqlSession.selectList("Item.selectBidC");
		}
		else if(alignName.equals("2")) {
			bidlist=(ArrayList)sqlSession.selectList("Item.selectBidC2");
		}
		else if(alignName.equals("3")) {
			bidlist=(ArrayList)sqlSession.selectList("Item.selectBidC3");
			
		}
		else if(alignName.equals("4")) {
			bidlist=(ArrayList)sqlSession.selectList("Item.selectBidC4");
		}
		else if(alignName.equals("5")) {
			bidlist=(ArrayList)sqlSession.selectList("Item.selectBidC5");
		}
		else if(alignName.equals("6")) {
			bidlist=(ArrayList)sqlSession.selectList("Item.selectBidC6");
		}
		else if(alignName.equals("7")) {
			bidlist=(ArrayList)sqlSession.selectList("Item.selectBidC7");
		}
		return bidlist;
	}

	@Override
	public ArrayList<Item> selectItem(SqlSessionTemplate sqlSession, String alignName) {
		
		ArrayList<Item> itemlist=null;
		if(alignName.equals("1")) {
			itemlist=(ArrayList)sqlSession.selectList("Item.selectItemC");
		}
		else if(alignName.equals("2")) {
			itemlist=(ArrayList)sqlSession.selectList("Item.selectItemC2");
			
		}
		else if(alignName.equals("3")) {
			itemlist=(ArrayList)sqlSession.selectList("Item.selectItemC3");
			
		}
		else if(alignName.equals("4")) {
			itemlist=(ArrayList)sqlSession.selectList("Item.selectItemC4");
		}
		else if(alignName.equals("5")) {
			itemlist=(ArrayList)sqlSession.selectList("Item.selectItemC5");
		}
		else if(alignName.equals("6")) {
			itemlist=(ArrayList)sqlSession.selectList("Item.selectItemC6");
		}
		else if(alignName.equals("7")) {
			itemlist=(ArrayList)sqlSession.selectList("Item.selectItemC7");
		}
		
		return itemlist;
	}

	@Override
	public ArrayList<Attachment> selectAttachment(SqlSessionTemplate sqlSession, String alignName) {
		ArrayList<Attachment> attachmentlist=null;
		if(alignName.equals("1")) {
			attachmentlist=(ArrayList)sqlSession.selectList("Item.selectAttachmentC");
		}
		else if(alignName.equals("2")) {
			attachmentlist=(ArrayList)sqlSession.selectList("Item.selectAttachmentC2");
		}
		else if(alignName.equals("3")) {
			attachmentlist=(ArrayList)sqlSession.selectList("Item.selectAttachmentC3");
			
		}
		else if(alignName.equals("4")) {
			attachmentlist=(ArrayList)sqlSession.selectList("Item.selectAttachmentC4");
		}
		else if(alignName.equals("5")) {
			attachmentlist=(ArrayList)sqlSession.selectList("Item.selectAttachmentC5");
		}
		else if(alignName.equals("6")) {
			attachmentlist=(ArrayList)sqlSession.selectList("Item.selectAttachmentC6");
		}
		else if(alignName.equals("7")) {
			attachmentlist=(ArrayList)sqlSession.selectList("Item.selectAttachmentC7");
		}
		return attachmentlist;
	}

	@Override
	public ArrayList<Member> selectMember(SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("Item.selectMember");
	}

	@Override
	public ArrayList<Member> selectMember(SqlSessionTemplate sqlSession, String alignName) {
		
		ArrayList<Member> memberlist=null;
		if(alignName.equals("1")) {
			memberlist=(ArrayList)sqlSession.selectList("Item.selectMemberC");
		}
		else if(alignName.equals("2")) {
			memberlist=(ArrayList)sqlSession.selectList("Item.selectMemberC2");
			
		}
		else if(alignName.equals("3")) {
			memberlist=(ArrayList)sqlSession.selectList("Item.selectMemberC3");
			
		}
		else if(alignName.equals("4")) {
			memberlist=(ArrayList)sqlSession.selectList("Item.selectMemberC4");
		}
		else if(alignName.equals("5")) {
			memberlist=(ArrayList)sqlSession.selectList("Item.selectMemberC5");
		}
		else if(alignName.equals("6")) {
			memberlist=(ArrayList)sqlSession.selectList("Item.selectMemberC6");
		}
		else if(alignName.equals("7")) {
			memberlist=(ArrayList)sqlSession.selectList("Item.selectMemberC7");
		}
		
		return memberlist;
	}

	@Override
	public ArrayList<Category> selectCategory(SqlSessionTemplate sqlSession, String categoryLevel) {
		ArrayList<Category> categorylist=null;
		
		if(categoryLevel.equals("1")) {
			categorylist=(ArrayList)sqlSession.selectList("Item.selectCategory1");
		}else if(categoryLevel.equals("2")) {
			categorylist=(ArrayList)sqlSession.selectList("Item.selectCategory2");
		}else if(categoryLevel.equals("3")) {
			categorylist=(ArrayList)sqlSession.selectList("Item.selectCategory3");
		}else if(categoryLevel.equals("4")) {
			categorylist=(ArrayList)sqlSession.selectList("Item.selectCategory4");
		}
		else if(categoryLevel.equals("5")) {
			categorylist=(ArrayList)sqlSession.selectList("Item.selectCategory5");
		}
		else if(categoryLevel.equals("6")) {
			categorylist=(ArrayList)sqlSession.selectList("Item.selectCategory6");
		}
		else if(categoryLevel.equals("7")) {
			categorylist=(ArrayList)sqlSession.selectList("Item.selectCategory7");
		}
		else if(categoryLevel.equals("8")) {
			categorylist=(ArrayList)sqlSession.selectList("Item.selectCategory8");
		}
		
		return categorylist;
	}

	@Override
	public ArrayList<Bid> selectBid1(SqlSessionTemplate sqlSession, String categoryLevel) {
		ArrayList<Bid> bidlist1=null;
		
		if(categoryLevel.equals("1")) {
			bidlist1=(ArrayList)sqlSession.selectList("Item.selectBid");
		}else if(categoryLevel.equals("2")) {
			bidlist1=(ArrayList)sqlSession.selectList("Item.selectBid");
		}else if(categoryLevel.equals("3")) {
			bidlist1=(ArrayList)sqlSession.selectList("Item.selectBid");
		}else if(categoryLevel.equals("4")) {
			bidlist1=(ArrayList)sqlSession.selectList("Item.selectBid");
		}
		else if(categoryLevel.equals("5")) {
			bidlist1=(ArrayList)sqlSession.selectList("Item.selectBid");
		}
		else if(categoryLevel.equals("6")) {
			bidlist1=(ArrayList)sqlSession.selectList("Item.selectBid");
		}
		else if(categoryLevel.equals("7")) {
			bidlist1=(ArrayList)sqlSession.selectList("Item.selectBid");
		}
		else if(categoryLevel.equals("8")) {
			bidlist1=(ArrayList)sqlSession.selectList("Item.selectBid");
		}
		
		return bidlist1;
	}

	@Override
	public ArrayList<Item> selectItem1(SqlSessionTemplate sqlSession, String categoryLevel) {
	ArrayList<Item> itemlist1=null;
		
		if(categoryLevel.equals("1")) {
			itemlist1=(ArrayList)sqlSession.selectList("Item.selectItemlist1");
		}else if(categoryLevel.equals("2")) {
			itemlist1=(ArrayList)sqlSession.selectList("Item.selectItemlist2");
		}else if(categoryLevel.equals("3")) {
			itemlist1=(ArrayList)sqlSession.selectList("Item.selectItemlist3");
		}else if(categoryLevel.equals("4")) {
			itemlist1=(ArrayList)sqlSession.selectList("Item.selectItemlist4");
		}
		else if(categoryLevel.equals("5")) {
			itemlist1=(ArrayList)sqlSession.selectList("Item.selectItemlist5");
		}
		else if(categoryLevel.equals("6")) {
			itemlist1=(ArrayList)sqlSession.selectList("Item.selectItemlist6");
		}
		else if(categoryLevel.equals("7")) {
			itemlist1=(ArrayList)sqlSession.selectList("Item.selectItemlist7");
		}
		else if(categoryLevel.equals("8")) {
			itemlist1=(ArrayList)sqlSession.selectList("Item.selectItemlist8");
		}
		
		return itemlist1;
	}

	@Override
	public ArrayList<Attachment> selectAttachment1(SqlSessionTemplate sqlSession, String categoryLevel) {
	ArrayList<Attachment> attachmentlist1=null;
		
		if(categoryLevel.equals("1")) {
			 attachmentlist1=(ArrayList)sqlSession.selectList("Item.selectAttachment");
		}else if(categoryLevel.equals("2")) {
			 attachmentlist1=(ArrayList)sqlSession.selectList("Item.selectAttachment");
		}else if(categoryLevel.equals("3")) {
			 attachmentlist1=(ArrayList)sqlSession.selectList("Item.selectAttachment");
		}else if(categoryLevel.equals("4")) {
			 attachmentlist1=(ArrayList)sqlSession.selectList("Item.selectAttachment");
		}
		else if(categoryLevel.equals("5")) {
			 attachmentlist1=(ArrayList)sqlSession.selectList("Item.selectAttachment");
		}
		else if(categoryLevel.equals("6")) {
			 attachmentlist1=(ArrayList)sqlSession.selectList("Item.selectAttachment");
		}
		else if(categoryLevel.equals("7")) {
			 attachmentlist1=(ArrayList)sqlSession.selectList("Item.selectAttachment");
		}
		else if(categoryLevel.equals("8")) {
			 attachmentlist1=(ArrayList)sqlSession.selectList("Item.selectAttachment");
		}
		
		return  attachmentlist1;
	}

	@Override
	public ArrayList<Member> selectMember1(SqlSessionTemplate sqlSession, String categoryLevel) {
	ArrayList<Member> memberlist1=null;
		
		if(categoryLevel.equals("1")) {
			memberlist1=(ArrayList)sqlSession.selectList("Item.selectMember");
		}else if(categoryLevel.equals("2")) {
			memberlist1=(ArrayList)sqlSession.selectList("Item.selectMember");
		}else if(categoryLevel.equals("3")) {
			memberlist1=(ArrayList)sqlSession.selectList("Item.selectMember");
		}else if(categoryLevel.equals("4")) {
			memberlist1=(ArrayList)sqlSession.selectList("Item.selectMember");
		}
		else if(categoryLevel.equals("5")) {
			memberlist1=(ArrayList)sqlSession.selectList("Item.selectMember");
		}
		else if(categoryLevel.equals("6")) {
			memberlist1=(ArrayList)sqlSession.selectList("Item.selectMember");
		}
		else if(categoryLevel.equals("7")) {
			memberlist1=(ArrayList)sqlSession.selectList("Item.selectMember");
		}
		else if(categoryLevel.equals("8")) {
			memberlist1=(ArrayList)sqlSession.selectList("Item.selectMember");
		}
		
		return memberlist1;
	}

	@Override
	public ArrayList<Bid> mainBid(SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("Item.selectBid");
	}

	@Override
	public ArrayList<Item> mainItem(SqlSessionTemplate sqlSession) {
		
		return (ArrayList)sqlSession.selectList("Item.popularItem");
		
	}

	@Override
	public ArrayList<Attachment> mainAttachment(SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("Item.selectAttachment");
	}

	@Override
	public ArrayList<Member> mainMember(SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("Item.selectMember");
	}

	@Override
	public ArrayList<Item> mainItem1(SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("Item.mainItem1");
	}

	@Override
	public ArrayList<Item> mainItem2(SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("Item.mainItem2");
	}


}
