package com.boxfish.lhb.dao;

import com.boxfish.lhb.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by boxfish on 15/12/15.
 */

//@RunWith(value = SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
public class UserDaoTest {

    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserDao dao;

    char[] names = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /**
     * 插入100行数据
     */
//    @Test
    public void insertTest() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) { //生成100个随机user对象
            User user = new User();
            user.setUserName(randomName()); //名字
            user.setMobile(generateMobile()); //手机号
            user.setGender((byte) (i % 2)); //性别
//            user.setCreateTime(Calendar.getInstance().getTime()); //创建时间
            users.add(user);
        }
        dao.save(users);//保存到数据库
    }

    /**
     * 随机生成一组首字母大写的Name
     *
     * @return
     */
    public String randomName() {
        int length = 0;
        while ((length = (int) (Math.random() * 10)) < 1) ; //生成一个随机整数，1到9
        StringBuilder nameBuilder = new StringBuilder(length);
        Random r = new Random();
        for (int i = length; i > 0; i--) {
            char c = names[r.nextInt(names.length)];//取出一个随机字母
            if (i == length) {
                //首字母大写
                c = Character.toUpperCase(c);
            }
            nameBuilder.append(c);
        }
        return nameBuilder.toString();
    }

    /**
     * 随机生成11位的数字串
     *
     * @return
     */
    public String generateMobile() {
        StringBuilder mobile = new StringBuilder(11);
        for (int i = 0; i < 11; i++) {
            mobile.append((int) (Math.random() * 10));
        }
        return mobile.toString();
    }

//    @Test
    public void updateTest() {
        User u = new User("John", "18801173638", (byte) 1, null);
        dao.save(u);
        User user2 = dao.findByUserName(u.getUserName()).get(0);
        assertTrue(u.getUserName().equals("John"));
        u.setMobile("12345678911");
        dao.save(u);
        User user3 = dao.getOne(user2.getId());
        assertEquals(u.getMobile(), user3.getMobile());
    }

//    @Test
    public void testInsert() {
        Calendar cl = Calendar.getInstance();
        cl.add(Calendar.DAY_OF_YEAR, -1); //昨天
        List<User> users = dao.findAll();
        assertNotNull(users);//非空
//        assertEquals(10, users.size()); //10个对象
//        logger.info("插入了10个对象");
        assertNotNull(users.get(0).getCreateTime());//创建时间非空
        users.forEach((user -> logger.info(user.toString())));

        logger.info("尝试更细创建时间");
        Date before = users.get(0).getCreateTime();
        logger.info("更新前，createTime = " + before);
        users.get(0).setCreateTime(cl.getTime());
        long id = users.get(0).getId();
        dao.save(users.get(0)); //保存
        User user = dao.findOne(id);
        Date after = user.getCreateTime();
        if (before.equals(after))
            logger.info("更新失败");
        else
            logger.info("更新成功");
        logger.info("更新后，createTime = " + user.getCreateTime());


//        dao.deleteAllInBatch(); //批量删除
//        users = dao.findAll();
//        assertTrue(users == null || users.size() == 0);
//        logger.info("全部删除了");
//        logger.info("User: " + new User().toString());

    }

//    @Test
    public void findByUserTest() {
        User u = new User();
        u.setId(76L);
        u.setMobile("76");
        u.setGender((byte) (76));
        List<User> users = dao.findByUserNameLikeOrMobileLike("%11%","%11%",new PageRequest(0,10)).getContent();
        System.out.println(users.size());
        if (users.size() > 0) {
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                System.out.println(user);

            }
        }
    }
}
