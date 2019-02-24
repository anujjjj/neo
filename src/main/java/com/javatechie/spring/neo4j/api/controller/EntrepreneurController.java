package com.javatechie.spring.neo4j.api.controller;

import com.javatechie.spring.neo4j.api.node.Entrepreneur;
import com.javatechie.spring.neo4j.api.repository.EntrepreneurRepository;
import com.javatechie.spring.neo4j.api.repository.ResponseRecommendations;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.*;

@RestController
public class EntrepreneurController {

	@Autowired
	private EntrepreneurRepository repository;

	@PostMapping("/addEntrepreneur")
	public String addEntrepreneur(@RequestBody Entrepreneur entrepreneur) {
		repository.save(entrepreneur);
		return "Entrepreneur Added";
	}

	@PutMapping("/updateFollows/{id}")
    public String updateFollows(@PathVariable(value = "id") @Valid String id , @RequestBody String idtofollow) {
//	    Entrepreneur e1 = repository.findByid(id);
//		Entrepreneur e2  = repository.findByid(idtofollow);

		return repository.addFollower();
//		if(e1==null){
//			return "1";
//		}
//		else{ return "2";}
//		if(e1!=null && e2!=null) {
//			e1.addFollower(e2);
//
//			repository.save(e1);
//			//work
//			return "Follower Added";
//		}
//		else {
//			return "User not found";
//		}
    }

	@GetMapping("/getEntrepreneurs")
	public List<Entrepreneur> getEntrepreneurs() {
		return (List<Entrepreneur>) repository.findAll();
	}

	@GetMapping("/getEntrepreneur/{name}")
	public Entrepreneur getEntrepreneur(@PathVariable String name) {
		return repository.findByName(name);
	}


	@DeleteMapping("/deleteEntrepreneur/{id}")
	public String deleteEntrepreneur(@PathVariable String id) {
		repository.deleteById(id);
		return "Entrepreneur deleted with id : " + id;
	}

	@GetMapping("/recommendations")
	public List<ResponseRecommendations> Recommendations(@RequestParam(value = "id",required = false)String id) {
			System.out.print(id);

//		return repository.mutualHaves(id);
		List<ResponseRecommendations> rp2 =  repository.mutualFriends("anuj");
		List<ResponseRecommendations> rp3 =	 repository.mutualGroups("anuj");
		List<ResponseRecommendations> rp1 =	 repository.mutualHaves("anuj");
		rp1.addAll(rp2);
		rp1.addAll(rp3);

		Set <ResponseRecommendations> r =  new HashSet<ResponseRecommendations>(rp1);
		List <ResponseRecommendations> result = new ArrayList<ResponseRecommendations>(r);
		return  result;

////		rp1.addAll(rp2);
//		Iterator<ResponseRecommendations> iterator1 = rp1.iterator();
//		Iterator<ResponseRecommendations> iterator2 = rp2.iterator();
////		 while loop
//		int oindex=0,iindex=0;
//		bool flag=false;
//		while (rp2.size() > oindex) {
////			System.out.println("value= " + iterator1.next());
//			ResponseRecommendations r2= rp2.get(oindex);
//			while(rp1.size() > oindex) {
//				ResponseRecommendations r1= rp1.get(iindex);
//				if(r1.getName().equals(r2.getName()))
//				{
//					r1.setMessage("Mutual Friends");
//					rp1.set(iindex,r1);
//					break;
//				}
//				else
//				{
//
//				}
//				iindex++;
//			}
//			oindex++;
//		}
//		return rp1;
	}

//	public Collection<ResponseRecommendations> graph(@RequestParam(value = "id",required = true)String id) {
//		System.out.print(id);
//		return repository.mutualGroups(id);
//	}

}
