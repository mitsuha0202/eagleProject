package com.kh.eg.auction.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.eg.attachment.model.vo.Attachment;
import com.kh.eg.auction.model.service.AuctionService;
import com.kh.eg.auction.model.service.AuctionServiceImpl;
import com.kh.eg.auction.model.vo.AuctionCount;
import com.kh.eg.auction.model.vo.PageInfo;
import com.kh.eg.auction.model.vo.Pagination;
import com.kh.eg.bidding.model.vo.Bid;
import com.kh.eg.category.model.vo.Category;
import com.kh.eg.item.model.vo.Item;
import com.kh.eg.member.model.vo.Member;

import net.sf.json.JSONArray;

@Controller
public class AuctionController {
	@Autowired 
	private AuctionService as;

	@RequestMapping("selectAlign.au")
	public @ResponseBody ArrayList<Item> selectAlign(Model model,@RequestParam String alignName) {


		
		ArrayList<Bid> list2=as.selectBid(alignName);
		ArrayList<Item> list1=as.selectItem(alignName);
		for(int i=0;i<list1.size();i++) {
			int count=0;
			for(int j=0;j<list2.size();j++) {
				if(list2.get(j).getItemNo()==(list1.get(i).getItemNo())) {
					count++;

				}
			}
			list1.get(i).setBidCount(count);

		}

		ArrayList<Attachment>list3=as.selectAttachment(alignName);

		for(int i=0;i<list1.size();i++) {
			for(int j=0;j<list3.size();j++) {
				if(list1.get(i).getItemNo()==(list3.get(j).getItemNo())) {
					list1.get(i).setAtta(list3.get(j));break;
				}
			}
		}
		
		ArrayList<Member> list4= as.selectMember(alignName);
		System.out.println(list4);
		for(int i=0;i<list1.size();i++) {
			for(int j=0;j<list4.size();j++) {
				if(list1.get(i).getMid().equals(list4.get(j).getMid())) {
					list1.get(i).setMemberName(list4.get(j));break;
				}
			}
		}
		
		
		for(Item i : list1) {
			if(i.getAtta() != null) {
				System.out.println(i.getItemNo() + ":" + i.getAtta().getChangeName());
			} else {
				System.out.println(i.getItemNo() + ":" + i.getAtta());
			}
			
		}
		
		
		if(alignName.equals("7")) {

			Collections.sort(list1, new Comparator<Item>() {
				@Override
				public int compare(Item o1, Item o2) {

					if(o1.getBidCount()>o2.getBidCount()) {
						return -1;
					}else if(o1.getBidCount()<o2.getBidCount()) {
						return 1;
					}else {
						return 0;
					}

				}
			});
		
			return list1;

		}
		else {
			
			return list1;
			

		}
		//return list1;

	}



	@RequestMapping("auctionCategory.au")
	public String selectAuction(HttpServletRequest request,Model model,Item it ) {

		ArrayList<Bid> list2=as.selectBid();
		ArrayList<Item> list1=as.selectItem();
		for(int i=0;i<list1.size();i++) {
			int count=0;
			for(int j=0;j<list2.size();j++) {
				if(list2.get(j).getItemNo()==(list1.get(i).getItemNo())) {
					count++;
				}
			}
			list1.get(i).setBidCount(count);

		};

		ArrayList<Attachment>list3=as.selectAttachment();

		for(int i=0;i<list1.size();i++) {
			for(int j=0;j<list3.size();j++) {
				if(list1.get(i).getItemNo()==(list3.get(j).getItemNo())) {
					list1.get(i).setAtta(list3.get(j));break;
				}
			}
		};

		
		ArrayList<Member> list4= as.selectMember();
		System.out.println(list4);
		for(int i=0;i<list1.size();i++) {
			for(int j=0;j<list4.size();j++) {
				if(list1.get(i).getMid().equals(list4.get(j).getMid())) {
					list1.get(i).setMemberName(list4.get(j));break;
				}
			}
		}
		
		
		
		model.addAttribute("list1",list1);
		
		
		
		return "auction/auction";
	}
	
	@RequestMapping("searchCate.au")
	public @ResponseBody ArrayList<Item> searchCategory(Model model,@RequestParam String categoryLevel) {
		
		
		
		ArrayList<Bid> list2=as.selectBid1(categoryLevel);
		ArrayList<Item> list1=as.selectItem1(categoryLevel);
		for(int i=0;i<list1.size();i++) {
			int count=0;
			for(int j=0;j<list2.size();j++) {
				if(list2.get(j).getItemNo()==(list1.get(i).getItemNo())) {
					count++;

				}
			}
			list1.get(i).setBidCount(count);

		}

		ArrayList<Attachment>list3=as.selectAttachment1(categoryLevel);

		for(int i=0;i<list1.size();i++) {
			for(int j=0;j<list3.size();j++) {
				if(list1.get(i).getItemNo()==(list3.get(j).getItemNo())) {
					list1.get(i).setAtta(list3.get(j));break;
				}
			}
		}
		
		ArrayList<Member> list4= as.selectMember1(categoryLevel);
		System.out.println(list4);
		for(int i=0;i<list1.size();i++) {
			for(int j=0;j<list4.size();j++) {
				if(list1.get(i).getMid().equals(list4.get(j).getMid())) {
					list1.get(i).setMemberName(list4.get(j));break;
				}
			}
		}
		ArrayList<Category> list5=as.selectCategory(categoryLevel);
		for(int i=0;i<list1.size();i++) {
			for(int j=0;j<list5.size();j++) {
				if(list1.get(i).getCategoryNo().equals(list5.get(j).getCategoryNo())) {
					list1.get(i).setCategoryInfo(list5.get(j));break;
				}
			}
		}
		return list1;
	
			

		
	}
	
	@RequestMapping("mainPage.au")
	public String selectMain(HttpServletRequest request,Model model,Item it ) {

		ArrayList<Bid> list2=as.selectBidM();
		ArrayList<Item> list1=as.selectItemM();
		for(int i=0;i<list1.size();i++) {
			int count=0;
			for(int j=0;j<list2.size();j++) {
				if(list2.get(j).getItemNo()==(list1.get(i).getItemNo())) {
					count++;
				}
			}
			list1.get(i).setBidCount(count);

		};
		ArrayList<Attachment>list3=as.selectAttachmentM();

		for(int i=0;i<list1.size();i++) {
			for(int j=0;j<list3.size();j++) {
				if(list1.get(i).getItemNo()==(list3.get(j).getItemNo())) {
					list1.get(i).setAtta(list3.get(j));break;
				}
			}
		};

		
		ArrayList<Member> list4= as.selectMemberM();
		System.out.println(list4);
		for(int i=0;i<list1.size();i++) {
			for(int j=0;j<list4.size();j++) {
				if(list1.get(i).getMid().equals(list4.get(j).getMid())) {
					list1.get(i).setMemberName(list4.get(j));break;
				}
			}
		}
		
		
		//리스트
		list2=as.selectBidM();
		ArrayList<Item> list5=as.selectItemM1();
		for(int i=0;i<list1.size();i++) {
			int count=0;
			for(int j=0;j<list2.size();j++) {
				if(list2.get(j).getItemNo()==(list5.get(i).getItemNo())) {
					count++;
				}
			}
			list5.get(i).setBidCount(count);

		};
		list3=as.selectAttachmentM();

		for(int i=0;i<list5.size();i++) {
			for(int j=0;j<list3.size();j++) {
				if(list5.get(i).getItemNo()==(list3.get(j).getItemNo())) {
					list5.get(i).setAtta(list3.get(j));break;
				}
			}
		};

		
		list4= as.selectMemberM();
		
		for(int i=0;i<list5.size();i++) {
			for(int j=0;j<list4.size();j++) {
				if(list5.get(i).getMid().equals(list4.get(j).getMid())) {
					list5.get(i).setMemberName(list4.get(j));break;
				}
			}
		}

		
		
		
		//스페셜
		list2=as.selectBidM();
		ArrayList<Item> list6=as.selectItemM2();
		for(int i=0;i<list6.size();i++) {
			int count=0;
			for(int j=0;j<list2.size();j++) {
				if(list2.get(j).getItemNo()==(list6.get(i).getItemNo())) {
					count++;
				}
			}
			list6.get(i).setBidCount(count);

		};
		list3=as.selectAttachmentM();

		for(int i=0;i<list6.size();i++) {
			for(int j=0;j<list3.size();j++) {
				if(list6.get(i).getItemNo()==(list3.get(j).getItemNo())) {
					list6.get(i).setAtta(list3.get(j));break;
				}
			}
		};

		
		list4= as.selectMemberM();
		System.out.println(list4);
		for(int i=0;i<list6.size();i++) {
			for(int j=0;j<list4.size();j++) {
				if(list6.get(i).getMid().equals(list4.get(j).getMid())) {
					list6.get(i).setMemberName(list4.get(j));break;
				}
			}
		}
		
		
		
		
		
		
		model.addAttribute("list1",list1);
	
		model.addAttribute("list5",list5);
		model.addAttribute("list6",list6);
		
		return "main/main";
	
	
	}

	@RequestMapping("selectCount.au")
	public @ResponseBody int selectCount(Model model) {
		int count = as.selectCount();
		return count;
	}

}
