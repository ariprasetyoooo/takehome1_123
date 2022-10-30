/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TakeHome1.takehome_1;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HAHAHA
 */
@Controller
public class myController {
    //@ResponseBody
    @RequestMapping("/input")
    public String getData (HttpServletRequest data, Model discountprocess){
        
        String namabarang = data.getParameter("namabarang");
        
        String harga = data.getParameter("harga");
        
        String jumlah = data.getParameter("jumlah");
               
        String diskon = "";
        Double Price = Double.valueOf(harga);
        Double Total = Double.valueOf(jumlah);
        Double PriceTotal = Price * Total;
        Double getTotal = null;
        
        if (PriceTotal < 10000)
        {
            getTotal = PriceTotal - (0 * PriceTotal/100);
            diskon = "0%";
        }
        else if (PriceTotal >= 10000 && PriceTotal < 50000)
        {
            getTotal = PriceTotal - (5 * PriceTotal/100);
            diskon = "5%";
        }
        else if (PriceTotal >= 50000 && PriceTotal <= 100000)
        {
            getTotal = PriceTotal - (10 * PriceTotal/100);
            diskon = "10%";
        }
        else if (PriceTotal > 100000)
        {
            getTotal = PriceTotal - (15 * PriceTotal/100);
            diskon = "15%";
        }
        
        discountprocess.addAttribute("namabarang", namabarang);
        discountprocess.addAttribute("harga", harga);
        discountprocess.addAttribute("jumlah", jumlah);
        discountprocess.addAttribute("diskon", diskon);
        discountprocess.addAttribute("Hasil", getTotal);
      
        return "hasil";
    }
}
