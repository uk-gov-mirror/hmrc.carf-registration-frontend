package viewmodels.checkAnswers.changeContactDetails

import models.UserAnswers
import pages.changeContactDetails.{ChangeDetailsIndividualHavePhonePage, ChangeDetailsOrgFirstHavePhonePage}
import play.api.i18n.Messages
import uk.gov.hmrc.govukfrontend.views.viewmodels.content.HtmlContent
import uk.gov.hmrc.govukfrontend.views.viewmodels.summarylist.SummaryListRow
import viewmodels.govuk.summarylist.*
import viewmodels.implicits.*

object ChangeDetailsOrgFirstHavePhoneSummary {
  def row(answers: UserAnswers)(implicit messages: Messages): Option[SummaryListRow] =
    answers.get(ChangeDetailsOrgFirstHavePhonePage).map { answer =>

      val value = if (answer) "site.yes" else "site.no"

      SummaryListRowViewModel(
        key = "changeOrgDetails.firstContact.summaryList.havePhone.key",
        value = ValueViewModel(value),
        actions = Seq(
          ActionItemViewModel(
            content = HtmlContent(s"""<span aria-hidden='true'>${messages("site.change")}</span>"""),
            href = controllers.routes.PlaceholderController.onPageLoad("Must redirect to /change-contact/organisation/have-phone page - CARF-187").url
          ).withVisuallyHiddenText(messages("changeOrgDetails.firstContact.summaryList.havePhone.key.hidden"))
        )
      )
    }
}
