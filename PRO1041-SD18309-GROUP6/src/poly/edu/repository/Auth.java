package poly.edu.repository;

import poly.edu.model.NhanVien;

public class Auth {
    public static NhanVien user = null;
    
    public static void clear(){
        Auth.user = null;
    }
    
    public static boolean isLogin(){
        return Auth.user != null;
    }
    
    public static boolean isManager(){
        return Auth.isLogin() && user.getCv().getId() == 1;
    }
}