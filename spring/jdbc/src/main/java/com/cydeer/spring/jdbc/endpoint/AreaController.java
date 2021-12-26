package com.cydeer.spring.jdbc.endpoint;

import com.cydeer.spring.jdbc.dao.AreaDao;
import com.cydeer.spring.jdbc.domain.Area;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author song.z
 * @date 2021/12/26 8:01 下午
 */
@RestController
public class AreaController {

    private final AreaDao areaDao;


    public AreaController(AreaDao areaDao) {
        this.areaDao = areaDao;
    }

    /**
     * curl http://localhost:8080/area/save -X POST -d '{"id":1,"code":"10000","name":"浙江"}' -H 'content-type:application/json'
     *
     * @param area
     * @return
     */
    @PostMapping("/area/save")
    public String save(@RequestBody Area area) {
        areaDao.save(area);
        return "save success";
    }

    /**
     * curl http://localhost:8080/area/update -X POST -d '{"id":1,"code":"10100","name":"杭州"}' -H 'content-type:application/json'
     *
     * @param area
     * @return
     */
    @PostMapping("/area/update")
    public String update(@RequestBody Area area) {
        areaDao.update(area);
        return "update success";
    }

    /**
     * curl http://localhost:8080/area/delete?id=1 -X POST
     *
     * @param id
     * @return
     */
    @PostMapping("/area/delete")
    public String delete(Integer id) {
        areaDao.delete(id);
        return "delete success";
    }


    /**
     * curl http://localhost:8080/area/list
     *
     * @return
     */
    @GetMapping("/area/list")
    public List<Area> list() {
        return areaDao.list();
    }

    /**
     * curl http://localhost:8080/area/detail?id=1
     *
     * @param id
     * @return
     */
    @GetMapping("/area/detail")
    public Area detail(Integer id) {
        return areaDao.findById(id);
    }


}
