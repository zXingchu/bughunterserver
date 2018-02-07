package bughunter.bughunterserver.factory;

import bughunter.bughunterserver.until.Constants;
import bughunter.bughunterserver.vo.ResultMessage;

public class ResultMessageFactory {

    public static ResultMessage getResultMessage(Object data){
        ResultMessage resultMessage=new ResultMessage();
        if(data==null)
            resultMessage=new ResultMessage(1, Constants.ERROR);
        else
            resultMessage=new ResultMessage(0,Constants.OKSTR,data);
        return resultMessage;
    }

    public static ResultMessage getResultMessage(boolean flag){
        ResultMessage resultMessage=new ResultMessage();
        if(flag)
            resultMessage=new ResultMessage(0);
        else
            resultMessage=new ResultMessage(1, Constants.ERROR);
        return resultMessage;
    }

    public static ResultMessage getResultMessage(int id){
        ResultMessage resultMessage=new ResultMessage();
        if(id>0)
            resultMessage=new ResultMessage(0,"",id);
        else
            resultMessage=new ResultMessage(1, Constants.ERROR);
        return resultMessage;
    }

}
