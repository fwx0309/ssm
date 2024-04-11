package org.fwx.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.fwx.pojo.Emp;
import org.fwx.pojo.EmpExample;
import org.fwx.utils.SqlSessionUtils;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName PageHelperTest
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/11 11:50
 * @Version 1.0
 */
public class PageHelperTest {
    @Test
    public void pageHelperTest(){
        SqlSession sqlsession = SqlSessionUtils.getSqlsession();
        EmpMapper mapper = sqlsession.getMapper(EmpMapper.class);

        Page<Emp> page = PageHelper.startPage(2, 5);

        List<Emp> list = mapper.selectByExample(null);
        System.out.println("page = " + page);
        System.out.println("--------------------");

        System.out.println("list = " + list);
        System.out.println("--------------------");

        // PageInfo<Emp> pageInfo = new PageInfo<>(page,5);
        // 输出数据格式：
        // PageInfo{
        //	    pageNum=2, pageSize=5, size=5, startRow=6, endRow=10, total=35, pages=7,
        //	    list=Page{count=true, pageNum=2, pageSize=5, startRow=5, endRow=10, total=35, pages=7, reasonable=false, pageSizeZero=false}
        //	    [Emp{empId=6, empName='小明2', age=18, gender='男', deptId=1}, Emp{empId=7, empName='小明3', age=18, gender='男', deptId=1},
        //	    Emp{empId=8, empName='张三', age=18, gender='男', deptId=1}, Emp{empId=9, empName='李四', age=18, gender='男', deptId=2},
        //	    Emp{empId=10, empName='王五', age=18, gender='男', deptId=3}],
        //	    prePage=1, nextPage=3, isFirstPage=false, isLastPage=false, hasPreviousPage=true,
        //	    hasNextPage=true, navigatePages=5, navigateFirstPage=1, navigateLastPage=5, navigatepageNums=[1, 2, 3, 4, 5]
        //  }
        PageInfo<Emp> pageInfo = new PageInfo<>(list,5);
        System.out.println("pageInfo = " + pageInfo);

    }
}
