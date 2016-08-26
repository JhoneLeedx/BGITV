package com.yxt.jhonelee.mapper;

import java.util.List;

import com.yxt.jhonelee.model.Address;

public interface AddressMapper {

	public List<Address> SelectAddress(String pid);
    public Address SelectOneAddress(String mCodevalue);
    
    
}
    
