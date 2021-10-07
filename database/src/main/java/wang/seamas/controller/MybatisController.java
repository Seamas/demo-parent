package wang.seamas.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wang.seamas.mapper.UserMapper;
import wang.seamas.model.User;
import wang.seamas.service.UserService;
import wang.seamas.vo.response.CommonResult;
import wang.seamas.vo.response.PagedResultVo;

import java.util.List;

@RestController
@RequestMapping("mybatis")
public class MybatisController extends BaseController{

    @Autowired
    private UserMapper mapper;

    @Override
    @Autowired
    public void setUserService(@Qualifier("mybatisUserServiceImpl") UserService userService) {
        super.setUserService(userService);
    }

    @PostMapping("page")
    public CommonResult<PagedResultVo> page() {
        IPage<User> page = new Page<>(1, 20);
        mapper.selectPage(page, null);

        return new CommonResult<>(new PagedResultVo<User>(page.getCurrent(), page.getSize(), page.getTotal(), page.getRecords()));
    }

    @PostMapping("pagehelper")
    public CommonResult<PagedResultVo> pagehelper() {
        PageInfo<Object> pageInfo = PageHelper.startPage(1, 20).doSelectPageInfo(() -> mapper.selectList(new QueryWrapper<>()));
        return new CommonResult<>(new PagedResultVo((long)pageInfo.getPageNum(), (long)pageInfo.getSize(), pageInfo.getTotal(), pageInfo.getList()));
    }
}
