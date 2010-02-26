package bootstrap.liftweb

import _root_.net.liftweb.http._
import _root_.net.liftweb.common.Full
/**
  * A class that's instantiated early and run.  It allows the application
  * to modify lift's environment
  */
class Boot { 
  def boot {
    // where to search snippet
    LiftRules.addToPackages("gcpens.portal.survey.admin");
    LiftRules.enableLiftGC = false
    LiftRules.autoIncludeAjax = _ => false
    ResponseInfo.docType = { 
      case _ if S.getDocType._1 => S.getDocType._2 
      case _ => Full(DocType.xhtmlStrict) 
    }
    // Build SiteMap
//    val entries = Menu(Loc("Home", List("index"), "Home")) :: Nil
//    LiftRules.setSiteMap(SiteMap(entries:_*))
  }
}

