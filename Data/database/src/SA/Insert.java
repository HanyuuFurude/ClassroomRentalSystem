package SA;

import java.util.List;

/**
 * created by sheting on 2019/4/13
 */
public class Insert {
    public Byte insert(Order order)
    {
        DBoperation dbo=new DBoperation();
        List<Time> res = dbo.selectTime(order.getclassRoom());
        for (int i = 0; i < res.size(); i++) {
            if((res.get(i).getStartTime() < order.getstartTime()) && (order.getstartTime() < res.get(i).getEndTime())
                    || (res.get(i).getStartTime() < order.getendTime()) && (order.getendTime() < res.get(i).getEndTime())
                    ||(order.getstartTime()<res.get(i).getStartTime()) && (order.getendTime()>res.get(i).getEndTime()))
                return 0x0016;
            else
                {
                dbo.insertOrder(order);
                return 0x0000;
            }

        }
    }
}
