package lectureexamples

import lectureexamples.JSON

class TestClass {
  new JSON{
    val data = JObj(Map(
      "firstName"->JStr("Jonh"),
      "lastName"->JStr("Smith"),
      "address"->JObj(Map(
        "streetaddress"->JStr("12 12 street"),
        "state"->JStr("NY"),
        "postalCode"->JNum(12345)
      )),
      "phoneNumbers"->JSeq(List(
        JObj(Map(
          "type"->JStr("home"), "number"->JStr("111-11-1111")
        )),
        JObj(Map(
          "type"->JStr("fax"), "number"->JStr("111-11-1111")
        ))
      ))
    ))
  
   //as the man says lets do something with the data
   def show(json:JSON):String=json match{
      case JSeq(elems)=>"["+()+"]"
      case JObj(bindings)=> val assocs = bindings map{case (key,value)=>"\"" + key + "\":" + show(value)}; "{" + (assocs mkString ",")+"}"
      case JNum(num)=> num.toString
      case JStr(str)=>'\"' + str + '\"'
      case JBool(b)=> b.toString
      case JNull() =>"null"
    }
  
  }                                              
 
}