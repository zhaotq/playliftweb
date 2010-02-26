package gcpens.portal.survey.admin.snippet

import net.liftweb.http.RequestVar
import scala.xml.NodeSeq
import net.liftweb.http.SHtml
import net.liftweb.util.Helpers._

class Main {
	var comment="ABC";
	object comm extends RequestVar("ABC");
	def newComment() = {
		println("new Comment:"+comm.is)
	}
	def list(xml: NodeSeq):NodeSeq={
		bind("act",xml, 
			"comment" -> SHtml.textarea(comm.is, (x:String)=>{comm.set(x)}, "cols" -> "40","rows" -> "10", "id"->"comments"),
			"new" -> SHtml.submit("New", newComment))
	}
}
