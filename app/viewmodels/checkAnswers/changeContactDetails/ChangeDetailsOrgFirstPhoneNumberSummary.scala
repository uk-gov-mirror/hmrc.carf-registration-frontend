package viewmodels.checkAnswers.changeContactDetails

import models.UserAnswers
import pages.changeContactDetails.ChangeDetailsOrgFirstPhoneNumberPage
import play.api.i18n.Messages
import play.twirl.api.HtmlFormat
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.HtmlContent
import uk.gov.hmrc.govukfrontend.views.viewmodels.summarylist.SummaryListRow
import viewmodels.govuk.summarylist.*
import viewmodels.implicits.*

object ChangeDetailsOrgFirstPhoneNumberSummary {

def row(answers: UserAnswers)(implicit messages: Messages): Option[SummaryListRow] =
  answers.get(ChangeDetailsOrgFirstPhoneNumberPage).map { answer =>
    SummaryListRowViewModel(
      key = "changeOrgDetails.firstContact.summaryList.phoneNumber.key",
      value = ValueViewModel(HtmlFormat.escape(answer).toString),
      actions = Seq(
        ActionItemViewModel(
          content = HtmlContent(s"""<span aria-hidden='true'>${messages("site.change")}</span>"""),
          href = controllers.routes.PlaceholderController.onPageLoad("Must redirect to /change-contact/organisation/phone page - CARF-188").url
        ).withVisuallyHiddenText(messages("changeOrgDetails.firstContact.summaryList.phoneNumber.key.hidden"))
      )
    )
  }
}