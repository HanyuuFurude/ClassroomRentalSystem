package SA;

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
        List<Time> res = dbo.selectTime(order.getClassRoom().getName());
        for (int i = 0; i < res.size(); i++) {
            if ((res.get(i).getStartTime().getTime() < order.getStartTime().getTime()) && (order.getStartTime().getTime() < res.get(i).getEndTime().getTime())
                    || (res.get(i).getStartTime().getTime() < order.getEndTime().getTime()) && (order.getEndTime().getTime() < res.get(i).getEndTime().getTime())
                    || (order.getStartTime().getTime() < res.get(i).getStartTime().getTime()) && (order.getEndTime().getTime() > res.get(i).getEndTime().getTime()))
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
