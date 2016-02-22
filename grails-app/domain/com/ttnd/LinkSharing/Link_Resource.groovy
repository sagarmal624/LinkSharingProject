package com.ttnd.LinkSharing


class Link_Resource extends Resource {
    String url;
    static constraints = {
        url(nullable:false ,blank: false,url:true,validator:{val,obj->!(val.isInteger())})

    }
    public String toString()
    {
        return url
    }
}