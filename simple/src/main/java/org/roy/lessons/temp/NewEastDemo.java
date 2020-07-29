package org.roy.lessons.temp;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NewEastDemo {

    /**
     * 1、有树节点表如下（树的高度不定）：
     * CREATE TABLE `node` (
     * `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
     * `name` VARCHAR(32) NOT NULL,
     * `pid` BIGINT NULL COMMENT '父节点ID'
     * );
     * <p>
     * 请用sql查询出所有非叶子节点的节点名称。
     */
    // 非叶子节点,则其id必然在pid里
    // select name from node where id in (select pid from node)
    public static void main(String[] args) {

    }

    /**
     * 2、（程序题）有N个鸡蛋，要依次投放到如下盒子中（盒子数未知，直至全部放入为止），
     * 【1】，【2】，【4】，【8】，【16】。。。。【？】
     * 请问，已知n个鸡蛋，最后一个盒子有多少个鸡蛋？
     */

    public static void q2() {

    }

    /**
     * 3.school,lesson类如下
     * // 学校数据
     * Class school{
     * int shoolid;
     * String schoolname; //学校名字
     * };
     * //上课数据
     * Class lesson{
     * int schoolid;
     * int studentCount; //学生数量
     * }
     * 分别有2个list：List<school> schools;List<lesson> lessons，存放school与lesson数据，lessions含有多条相同schoolid的数据，
     * 现在需要统计每个学校上课的学生总数，并且将学校数据按照上课学生总数降序排列，将上课学生总数>1000的学校名字存放到一个list中。
     */


    public static List<String> q3(List<School> schools, List<Lesson> lessons) {
        Map<Integer,School> schoolMap = Maps.newHashMap();
        schools.forEach(s -> schoolMap.put(s.schoolId,s));

        List<SchoolAndTotal> schoolAndTotalList = Lists.newArrayList();
        lessons.stream()
                .collect(Collectors.groupingBy(e -> e.schoolId))
                .forEach((id, list) -> {
                    int total = list.stream()
                            .mapToInt(e -> e.studentCount)
                            .sum();
                    SchoolAndTotal schoolAndCnt = new SchoolAndTotal();
                    schoolAndCnt.schoolId = id;
                    schoolAndCnt.total = total;
                    schoolAndCnt.schoolName = schoolMap.get(id).schoolName;
                    schoolAndTotalList.add(schoolAndCnt);
                });
        // 排序,降序
        schoolAndTotalList.sort((o1,o2) -> Integer.compare(o2.total,o1.total));
        // 输出大于1000的
        return schoolAndTotalList.stream()
                .filter(e -> e.total > 1000)
                .map(e -> e.schoolName)
                .collect(Collectors.toList());
    }


    static class SchoolAndTotal {
        public int schoolId;
        public String schoolName;
        public int total;
    }

    static class School {
        public int schoolId;
        public String schoolName; //学校名字
    }

    static class Lesson {
        public int schoolId;
        public int studentCount; // 学生数量
    }

}
