package hbx.tapps.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hbx.tapps.models.CategoryInfo;
import hbx.tapps.models.UserInfo;

public final class DataRepository {
    private static final HashMap<String, Object> _rmap = new HashMap<String, Object>();

    public static final String USER_INFO = "userInfo";
    private static final List<UserInfo> _userInfoList = new ArrayList<UserInfo>();

    public static final String CATEGORY_INFO = "categoryInfo";
    private static final List<CategoryInfo> _categoryInfoList = new ArrayList<CategoryInfo>();

    static {
        _rmap.put(USER_INFO, _userInfoList);
        _rmap.put(CATEGORY_INFO, _categoryInfoList);
    }

    public static Object get_infos(String knm) {
        if (_rmap.containsKey(knm)) {
            return _rmap.get(knm);
        } else {
            return null;
        }
    }
}
