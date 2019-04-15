package cn.zzu.core;

import cn.zzu.Utils.RandomUtils;
import org.springframework.stereotype.Service;

/**
 * token
 *
 * @author silence
 * @create 2019-04-15-9:47
 */
@Service
public class TokenService {


  public Long createToken(){
      return RandomUtils.genId();
  }


}
