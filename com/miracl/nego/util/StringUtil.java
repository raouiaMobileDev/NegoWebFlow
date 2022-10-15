package com.miracl.nego.util;

import java.util.Vector;

/**
 *
 * @author rawia
 */
public class StringUtil {

    private StringUtil() {
    }

    public static boolean isEmpty(String s) {
        if (s == null) {
            return true;
        }
        if (s.equals("")) {
            return true;
        }
        return false;
    }

   public static boolean isBlank(String s) {
        if (s == null) {
            return true;
        }
        if (s.trim().equals("")) {
            return true;
        }
        return false;
    }
/**
 *
 * @param nomFile
 * @return
 */
   public static String doTypeMime(String nomFile)
   { 
       char[] chars=nomFile.toCharArray();
       for(int i=0;i<chars.length;i++)
       {
           if(chars[i] == '.')
               return nomFile.substring(i, chars.length);
       }
       return null;
   }
   /**
    *
    * @param sg
    * @param sp
    * @return
    */
   public static boolean isExist(String sg,String sp)
   {
      return sg.startsWith(sp);
   }
   /**
    *
    * @param s
    * @param suffix
    * @return
    */
   public static String doSuffix (String s,String suffix)
   {
       if(s.endsWith(suffix))
           return s;
       else
           return s+suffix;
   }
   /**
    * 
    * @param s
    * @return
    */
   public static Vector doSeparate(String s)
{
     s=s.trim();
       Vector v=new Vector();
                String[] x=   s.split(",");
                for(int i=0;i<x.length;i++)
                v.add(x[i]);
    return v;

}

}
