package com.sa.net.DB;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.List;

/**
 * created by lyx on 2019/4/13
 * 通过判断时间的合理性检查能否插入数据库
 */
public class Insert {
    public Byte insert(Order order) throws IOException {
        DBoperation dbo = new DBoperation();
        List<Updatesql> res = dbo.RoomSelectOrder(order.getClassRoom().getName());
        for (int i = 0; i < res.size(); i++) {
            if ((res.get(i).getStarttime().getTime() < order.getStartTime().getTime()) && (order.getStartTime().getTime() < res.get(i).getEndtime().getTime())
                    || (res.get(i).getStarttime().getTime() < order.getEndTime().getTime()) && (order.getEndTime().getTime() < res.get(i).getEndtime().getTime())
                    || (order.getStartTime().getTime() < res.get(i).getStarttime().getTime()) && (order.getEndTime().getTime() > res.get(i).getEndtime().getTime()))
                return 0x0016;
            else {
                dbo.insertOrder(order);
            }
        }
        return 0x0000;
    }

    public  static void main(String[] args)
    {
        System.out.println("1");
    }
}
