package utils

import com.google.inject.Inject
import models.UserAnswers
import pages.changeContactDetails.{ChangeDetailsOrgFirstHavePhonePage, ChangeDetailsOrgFirstNamePage}
import play.api.Logging
import play.api.i18n.Messages
import uk.gov.hmrc.govukfrontend.views.viewmodels.summarylist.SummaryListRow
import viewmodels.checkAnswers.changeContactDetails.*

class ChangeOrganisationDetailsHelper @Inject() extends Logging {

  def getFirstContactDetailsSectionMaybe(userAnswers: UserAnswers)(implicit messages: Messages): Option[Seq[SummaryListRow]] = {
    for {
      nameRow <- ChangeDetailsOrgFirstNameSummary.row(userAnswers)
      emailRow <- ChangeDetailsOrgFirstEmailSummary.row(userAnswers)
      havePhone <- userAnswers.get(ChangeDetailsOrgFirstHavePhonePage)
      havePhoneRow <- ChangeDetailsOrgFirstHavePhoneSummary.row(userAnswers)
    } yield
      if (havePhone) {
        ChangeDetailsOrgFirstPhoneNumberSummary.row(userAnswers).map {
          Seq(emailRow, havePhoneRow, _)
        }
      } else {
        Some(Seq(emailRow, havePhoneRow))
      }
  }.flatten
}
