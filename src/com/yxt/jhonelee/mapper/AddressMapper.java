package com.yxt.jhonelee.mapper;

import java.util.List;

import com.yxt.jhonelee.model.Address;

public interface AddressMapper {

	public List<Address> SelectAddress(String pid);//通过pid查出所有的address
    public Address SelectOneAddress(String mCodevalue);//通过codevalue查出对应的address
    
    
}
    
