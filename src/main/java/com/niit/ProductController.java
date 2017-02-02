package com.niit;

import java.io.BufferedOutputStream;


import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.CategoryInfo;
import com.niit.model.ProductInfo;
import com.niit.services.CategoryService;
import com.niit.services.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService pservice;//Adding service class of product with help of autowiring
	ProductInfo productObject=null;
	ServletContext servletContext;//including servlet context foe uploading file
	@Autowired
	CategoryService cs;
	@RequestMapping("/product")//url mapping is done for product
	public  ModelAndView  getProductPage(Map<String, Object> map, @ModelAttribute("product") ProductInfo product,BindingResult result,Model model) {
System.out.println("view product adding page");
map.put("productList", pservice.getList());
map.put("categoryList", cs.getAllCategory());
model.addAttribute("product",new ProductInfo());
		return new  ModelAndView("Product");
	}
	

	@RequestMapping("/productadd")//url mapping for adding the product in database
	public  ModelAndView getProduct(@Valid @ModelAttribute("product")ProductInfo product,BindingResult result,HttpServletRequest hm,Model model) {
    
     servletContext =hm.getServletContext();
     model.addAttribute("product",new ProductInfo());
     if (result.hasErrors()) {
    	 
    	 System.out.println("validation in add product");
       	 return new ModelAndView("Product");  
       	}
     
     else
    	 {
    	 boolean ex=false;
    	 List<CategoryInfo> category=cs.getAllCategory();
    	 for(CategoryInfo x:category)
    	 {
    		 if(product.getCategory_name().equals(x.getCategory_name())==true)
    		 {
    			 product.setCategory_fk(x);
    			 pservice.add(product);
    			 ex=true;
    			 break;
    			 
    		 }
    		 
    	 }
    	 if(!ex){
    		 CategoryInfo c=new CategoryInfo();
    		 c.setCategory_name(product.getCategory_name());
    		 cs.add(c);
    		 product.setCategory_fk(c);
    		 
    	 }
    	 if (!product.getImage().isEmpty())
    	 
         {System.out.println("get image");
			try {
				 System.out.println("get image "+servletContext);
				byte[] bytes = product.getImage().getBytes();
				System.out.println("get image "+servletContext.getRealPath("/"));
				// Creating the directory to store file
				String rootPath = servletContext.getRealPath("/");
//				String rootPath = System.getProperty("catalina.home");
				System.out.println("get image "+rootPath);
				File dir = new File(rootPath + File.separator + "resources/images");
				if (!dir.exists())
					{dir.mkdirs();
			 }else{
	    		 System.out.println("filee "+dir.exists());
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator +product.getProduct_name()+".jpg");
				System.out.println(serverFile);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				System.out.println("server file location"+serverFile.getAbsolutePath());
				 pservice.add(product);
	    	 }
				return new ModelAndView("redirect:list");
				} catch (Exception e) {
					e.printStackTrace();
					return new ModelAndView("redirect:list");
				}
			} else {
				return new ModelAndView("redirect:list");
			
			}
		}}

//				// Create the file on server
//				File serverFile = new File(dir.getAbsolutePath()
//						+ File.separator + product.getProduct_name()+".jpg");
//				BufferedOutputStream stream = new BufferedOutputStream(
//						new FileOutputStream(serverFile));
//				stream.write(bytes);
//				stream.close();
//
//				System.out.println("Server File Location="
//						+ serverFile.getAbsolutePath());
//
//				return "You successfully uploaded file=" + product.getProduct_name();
//			} catch (Exception e) {
//				return "You failed to upload " + product.getProduct_name() + " => " + e.getMessage();
//			}
//		} else {
//			return "You failed to upload " + product.getProduct_name()
//					+ " because the file was empty.";
//		}
	
				
        
		
				
//		return "redirect:list";
	
	@RequestMapping("/display")//url mapping for displaying the image 
	public ModelAndView viewImg(@ModelAttribute ProductInfo product,Map<String, Object> map)
	{
		ModelAndView mv=new ModelAndView("display");
	map.put("List",pservice.getList());
	System.out.println("getting details from list");
		map.put("image",product.getProduct_name());
		System.out.println("getting image using name of the product");
		return mv;
	}
	
	@RequestMapping("/list")//url mapping for getting list of product details
	 public ModelAndView getList() {
	  List list = pservice.getList();
	  System.out.println("product list");
	  return new ModelAndView("List", "list", list);
	 }


	 @RequestMapping("/delete")//url mapping for deleting the products
	 public ModelAndView deleteProduct(@RequestParam int id) {
	  pservice.deleteRow(id);
	  System.out.println("delete product");
	  return new ModelAndView("redirect:list");
	 }
 @RequestMapping("/edit")//url mapping for editing the products
	 public ModelAndView editProduct(@RequestParam int id,
	   @ModelAttribute ProductInfo product, BindingResult result,Map<String, Object> map) {
	   productObject = pservice.getRowById(id);
	   map.put("ProductInfo",product);
	   System.out.println("edit product");
	  return new ModelAndView("edit", "productObject", productObject);
	 }
	 @RequestMapping("/update")//url mapping for update
	 public ModelAndView updateProduct(@ModelAttribute ProductInfo product, BindingResult result) {
		 int id = productObject.getId();
		 System.out.println(id);
		 product.setId(id);
		 pservice.updateRow(product);
		 System.out.println("update product");
	  return new ModelAndView("redirect:list");
	 }
}
