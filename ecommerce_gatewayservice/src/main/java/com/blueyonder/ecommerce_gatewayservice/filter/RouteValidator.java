package com.blueyonder.ecommerce_gatewayservice.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.function.Predicate;
@Component
public class RouteValidator {
	
	public static  final List<String> openApiEndpoints=List.of(
			"/signin",
			"/signup",
			"/",
			"/eureka",
			"/api-docs"
			);
	
	public static  final List<String> isAdmin=List.of(
			"/shopservice/ecommerce/api/v1/category/add-category",
			"/shopservice/ecommerce/api/v1/category/update-category-by-id",
			"/shopservice/ecommerce/api/v1/category/update-category-by-name",
//			"/productandcategory/ecommerceapp/api/v1/category/deletecategory",
//			"/shopservice/ecommerce/api/v1/product/delete-product",
			"/shopservice/ecommerce/api/v1/product/update-by-id",
			"/shopservice/ecommerce/api/v1/product/update-by-name",
			"/shopservice/ecommerce/api/v1/product/add-product"
			
			);
	public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
            
            
            public Predicate<ServerHttpRequest> isAdminSecured =
                    request -> isAdmin
                            .stream()
                            .anyMatch(uri -> request.getURI().getPath().contains(uri));
			

}