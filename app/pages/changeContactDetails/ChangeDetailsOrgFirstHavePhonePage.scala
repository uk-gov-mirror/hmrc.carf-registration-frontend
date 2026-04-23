package pages.changeContactDetails

import pages.QuestionPage
import play.api.libs.json.JsPath

case object ChangeDetailsOrgFirstHavePhonePage extends QuestionPage[Boolean] {

  override def path: JsPath = JsPath \ toString

  override def toString: String = "changeDetailsOrgFirstHavePhonePage"
}
