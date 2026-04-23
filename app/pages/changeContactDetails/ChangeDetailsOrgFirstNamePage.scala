package pages.changeContactDetails

import pages.QuestionPage
import play.api.libs.json.JsPath

case object ChangeDetailsOrgFirstNamePage extends QuestionPage[String] {

  override def path: JsPath = JsPath \ toString

  override def toString: String = "changeDetailsOrgFirstNamePage"
}
