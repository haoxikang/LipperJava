package com.fallllllll.lipper.data.local.user;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by fallllllll on 2017/3/16.
 */

public class UserToken extends RealmObject {
    @PrimaryKey
    private String id = "token";
    private String access_token;
    private String token_type;
    private String scope;
    private int created_at;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }
}
