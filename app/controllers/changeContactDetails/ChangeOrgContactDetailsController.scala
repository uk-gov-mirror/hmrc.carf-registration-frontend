package controllers.changeContactDetails

import com.google.inject.Inject
import controllers.actions.{CarfIdRetrievalAction, ChangeDetailsDataRequiredAction}
import controllers.routes
import play.api.Logging
import play.api.i18n.I18nSupport
import play.api.mvc.{Action, AnyContent, MessagesControllerComponents}
import services.SubscriptionService
import uk.gov.hmrc.play.bootstrap.frontend.controller.FrontendBaseController
import utils.ChangeIndividualDetailsHelper
import views.html.ChangeOrgContactDetailsView

import scala.concurrent.{ExecutionContext, Future}

class ChangeOrgContactDetailsController  @Inject() (
                                                     val controllerComponents: MessagesControllerComponents,
                                                     carfIdRetrieval: CarfIdRetrievalAction,
                                                     changeDetailsDataRequiredAction: ChangeDetailsDataRequiredAction,
                                                     subscriptionService: SubscriptionService,
                                                     changeDetailsHelper: ChangeIndividualDetailsHelper,
                                                     view: ChangeOrgContactDetailsView
                                                   )(implicit ec: ExecutionContext)
  extends FrontendBaseController
    with I18nSupport
    with Logging {

  def onPageLoad(): Action[AnyContent] = (carfIdRetrieval() andThen changeDetailsDataRequiredAction).async {
    implicit request =>

    val backToManageLink =
      routes.PlaceholderController.onPageLoad("Must redirect to service home page (CARF-411)").url

      request.userAnswers.displaySubscriptionResponse.fold(
        Future.successful(Redirect(controllers.routes.JourneyRecoveryController.onPageLoad()))
      ) { displaySubscriptionResponse =>
        
      }
    
  }
}
