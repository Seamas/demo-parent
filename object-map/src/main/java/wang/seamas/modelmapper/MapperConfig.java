package wang.seamas.modelmapper;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import wang.seamas.model.entity.UserEntity;
import wang.seamas.model.vo.UserVo;

import java.util.Date;

@Configuration
public class MapperConfig {

    @Bean
    @Scope("singleton")
    public ModelMapper getModelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        mapper.getConfiguration().setAmbiguityIgnored(true);

        // 增加自定义转换器
        Converter<Date, String> dateToString = new DateStringConverter();
        mapper.createTypeMap(Date.class, String.class)
                .setConverter(dateToString);
        mapper.addConverter(dateToString);

        mapper.createTypeMap(UserEntity.class, UserVo.class);

        return mapper;
    }
}
