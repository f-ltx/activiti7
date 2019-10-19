package cn.ltx.activiti7.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String GLOBAL_ERROR_VIEW = "error";

    /**
     * Description:统一跳转页面
     */
//    @ExceptionHandler(value = Exception.class)
//    public Object errorHandler(HttpServletRequest reqest,
//                               HttpServletResponse response, Exception e) throws Exception {
//        e.printStackTrace();
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", reqest.getRequestURL());
//        mav.setViewName(GLOBAL_ERROR_VIEW);
//        return mav;
//    }

    /**
     * Description:统一返回json错误信息，与跳转页面只存在一个
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, Exception e) {
        ErrorInfo<String> r = new ErrorInfo<String>();
        r.setMessage(e.getMessage() == null ? "" : e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData(e.getClass().getName());
        r.setUrl(req.getRequestURI());
        return r;
    }

}