package com.jaats.agrovehicledriver.net;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.jaats.agrovehicledriver.listeners.AccessibilityListener;
import com.jaats.agrovehicledriver.listeners.AppStatusListener;
import com.jaats.agrovehicledriver.listeners.BasicListener;
import com.jaats.agrovehicledriver.listeners.CommentListListener;
import com.jaats.agrovehicledriver.listeners.DocumentStatusListener;
import com.jaats.agrovehicledriver.listeners.HelpListListener;
import com.jaats.agrovehicledriver.listeners.HelpListener;
import com.jaats.agrovehicledriver.listeners.IssueListListener;
import com.jaats.agrovehicledriver.listeners.LoginListener;
import com.jaats.agrovehicledriver.listeners.PhoneRegistrationListener;
import com.jaats.agrovehicledriver.listeners.PolyPointListener;
import com.jaats.agrovehicledriver.listeners.ProfileListener;
import com.jaats.agrovehicledriver.listeners.RatingDetailsListener;
import com.jaats.agrovehicledriver.listeners.RegistrationListener;
import com.jaats.agrovehicledriver.listeners.RequestDetailsListener;
import com.jaats.agrovehicledriver.listeners.TripDetailsListener;
import com.jaats.agrovehicledriver.listeners.TripFeedbackListener;
import com.jaats.agrovehicledriver.listeners.TripListListener;
import com.jaats.agrovehicledriver.listeners.TripSummaryListener;
import com.jaats.agrovehicledriver.listeners.WeeklyEarningsListener;
import com.jaats.agrovehicledriver.model.AccessibilityBean;
import com.jaats.agrovehicledriver.model.AppStatusBean;
import com.jaats.agrovehicledriver.model.AuthBean;
import com.jaats.agrovehicledriver.model.BasicBean;
import com.jaats.agrovehicledriver.model.CommentListBean;
import com.jaats.agrovehicledriver.model.DocumentStatusBean;
import com.jaats.agrovehicledriver.model.HelpBean;
import com.jaats.agrovehicledriver.model.HelpListBean;
import com.jaats.agrovehicledriver.model.IssueListBean;
import com.jaats.agrovehicledriver.model.PolyPointBean;
import com.jaats.agrovehicledriver.model.ProfileBean;
import com.jaats.agrovehicledriver.model.RatingDetailsBean;
import com.jaats.agrovehicledriver.model.RequestDetailsBean;
import com.jaats.agrovehicledriver.model.TripBean;
import com.jaats.agrovehicledriver.model.TripFeedbackBean;
import com.jaats.agrovehicledriver.model.TripListBean;
import com.jaats.agrovehicledriver.model.TripSummaryBean;
import com.jaats.agrovehicledriver.model.WeeklyEarningsBean;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.AccessibilityTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.AppStatusTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.ArrivalConfirmationTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.CashCollectionTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.CommentListTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.DocumentStatusTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.DocumentUploadTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.DriverAccessibilityTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.DriverStatusChangeTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.DriverStatusTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.DriverTypeRegistrationTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.ForgotPasswordTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.HelpListTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.HelpPageReviewTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.HelpTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.IssueListTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.LoginTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.MobileAvailabilityCheckTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.OTPResendCodeTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.OTPSubmitTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.PhoneRegistrationTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.PolyPointTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.ProfilePhotoUploadTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.ProfileTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.ProfileUpdateTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.RatingDetailsTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.RegistrationTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.RequestDetailsTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.TodayTripListTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.TripAcceptTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.TripCompletionTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.TripDetailsTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.TripFeedbackTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.TripHistoryTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.TripStartTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.TripSummaryTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.UpdateDriverLocationTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.UpdateFCMTokenTask;
import com.jaats.agrovehicledriver.net.WSAsyncTasks.WeeklyEarningsTask;
import com.jaats.agrovehicledriver.util.AppConstants;


public class DataManager {


    public static void fetchTripDetails(HashMap<String, String> urlParams, final TripDetailsListener listener) {

        TripDetailsTask tripDetailsTask = new TripDetailsTask(urlParams);
        tripDetailsTask.setTripDetailsTaskListener(new TripDetailsTask.TripDetailsTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(TripBean tripBean) {
                if (tripBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (tripBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(tripBean);
                    } else if (tripBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(tripBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        tripDetailsTask.execute();
    }

    public static void fetchDriverStatus(HashMap<String, String> urlParams, final BasicListener listener) {

        DriverStatusTask driverStatusTask = new DriverStatusTask(urlParams);
        driverStatusTask.setDriverStatusTaskListener(new DriverStatusTask.DriverStatusTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(BasicBean basicBean) {
                if (basicBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (basicBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(basicBean);
                    } else if (basicBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(basicBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        driverStatusTask.execute();
    }

    public static void performHelpPageReview(JSONObject postData, final BasicListener listener) {

        HelpPageReviewTask helpPageReviewTask = new HelpPageReviewTask(postData);
        helpPageReviewTask.setHelpPageReviewTaskListener(new HelpPageReviewTask.HelpPageReviewTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(BasicBean basicBean) {
                if (basicBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (basicBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(basicBean);
                    } else if (basicBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(basicBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        helpPageReviewTask.execute();
    }

    public static void fetchAppStatus(HashMap<String, String> urlParams, final AppStatusListener listener) {

        AppStatusTask appStatusTask = new AppStatusTask(urlParams);
        appStatusTask.setAppStatusTaskListener(new AppStatusTask.AppStatusTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(AppStatusBean appStatusBean) {
                if (appStatusBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (appStatusBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(appStatusBean);
                    } else if (appStatusBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(appStatusBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        appStatusTask.execute();
    }

    public static void performTripStart(JSONObject postData, final BasicListener listener) {

        TripStartTask tripStartTask = new TripStartTask(postData);
        tripStartTask.setTripStartTaskListener(new TripStartTask.TripStartTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(BasicBean basicBean) {
                if (basicBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (basicBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(basicBean);
                    } else if (basicBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(basicBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        tripStartTask.execute();
    }

    public static void performArrivalConfirmation(JSONObject postData, final BasicListener listener) {

        ArrivalConfirmationTask arrivalConfirmationTask = new ArrivalConfirmationTask(postData);
        arrivalConfirmationTask.setArrivalConfirmationTaskListener(new ArrivalConfirmationTask.ArrivalConfirmationTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(BasicBean basicBean) {
                if (basicBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (basicBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(basicBean);
                    } else if (basicBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(basicBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        arrivalConfirmationTask.execute();
    }


    public static void performTripCompletion(JSONObject postData, final TripDetailsListener listener) {

        TripCompletionTask tripCompletionTask = new TripCompletionTask(postData);
        tripCompletionTask.setTripCompletionTaskListener(new TripCompletionTask.TripCompletionTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(TripBean tripBean) {
                if (tripBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (tripBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(tripBean);
                    } else if (tripBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(tripBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        tripCompletionTask.execute();
    }

    public static void performCashCollection(JSONObject postData, final BasicListener listener) {

        CashCollectionTask cashCollectionTask = new CashCollectionTask(postData);
        cashCollectionTask.setCashCollectionTaskListener(new CashCollectionTask.CashCollectionTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(BasicBean basicBean) {
                if (basicBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (basicBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(basicBean);
                    } else if (basicBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(basicBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        cashCollectionTask.execute();
    }

    public static void performTripAccept(JSONObject postData, final TripDetailsListener listener) {

        TripAcceptTask tripAcceptTask = new TripAcceptTask(postData);
        tripAcceptTask.setTripAcceptTaskListener(new TripAcceptTask.TripAcceptTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(TripBean tripBean) {
                if (tripBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (tripBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(tripBean);
                    } else if (tripBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(tripBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        tripAcceptTask.execute();
    }

    public static void fetchRequestDetails(HashMap<String, String> urlParams, final RequestDetailsListener listener) {

        RequestDetailsTask requestDetailsTask = new RequestDetailsTask(urlParams);
        requestDetailsTask.setRequestDetailsTaskListener(new RequestDetailsTask.RequestDetailsTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(RequestDetailsBean requestDetailsBean) {
                if (requestDetailsBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (requestDetailsBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(requestDetailsBean);
                    } else if (requestDetailsBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(requestDetailsBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        requestDetailsTask.execute();
    }

    public static void performMobileAvailabilityCheck(JSONObject postData, final BasicListener listener) {

        MobileAvailabilityCheckTask mobileAvailabilityCheckTask = new MobileAvailabilityCheckTask(postData);
        mobileAvailabilityCheckTask.setMobileAvailabilityCheckTaskListener(
                new MobileAvailabilityCheckTask.MobileAvailabilityCheckTaskListener() {
                    @Override
                    public void dataDownloadedSuccessfully(BasicBean basicBean) {
                        if (basicBean == null)
                            listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                        else {
                            if (basicBean.getStatus().equalsIgnoreCase("Success")) {
                                listener.onLoadCompleted(basicBean);
                            } else if (basicBean.getStatus().equalsIgnoreCase("Error")) {
                                listener.onLoadFailed(basicBean.getErrorMsg());
                            } else {
                                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                            }
                        }
                    }

                    @Override
                    public void dataDownloadFailed() {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                });
        mobileAvailabilityCheckTask.execute();
    }

    public static void performProfileUpdate(JSONObject postData, ArrayList<String> fileList, final BasicListener listener) {

        ProfileUpdateTask profileUpdateTask = new ProfileUpdateTask(postData, fileList);
        profileUpdateTask.setProfileUpdateTaskListener(new ProfileUpdateTask.ProfileUpdateTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(BasicBean basicBean) {
                if (basicBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (basicBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(basicBean);
                    } else if (basicBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(basicBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        profileUpdateTask.execute();
    }

    public static void fetchHelp(HashMap<String, String> urlParams, final HelpListener listener) {

        HelpTask helpTask = new HelpTask(urlParams);
        helpTask.setHelpTaskListener(new HelpTask.HelpTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(HelpBean helpBean) {
                if (helpBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (helpBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(helpBean);
                    } else if (helpBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(helpBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        helpTask.execute();
    }

    public static void fetchHelpList(HashMap<String, String> urlParams, final HelpListListener listener) {

        HelpListTask helpListTask = new HelpListTask(urlParams);
        helpListTask.setHelpListTaskListener(new HelpListTask.HelpListTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(HelpListBean helpListBean) {
                if (helpListBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (helpListBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(helpListBean);
                    } else if (helpListBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(helpListBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        helpListTask.execute();
    }

    public static void fetchCommentList(HashMap<String, String> urlParams, final CommentListListener listener) {

        CommentListTask commentListTask = new CommentListTask(urlParams);
        commentListTask.setCommentListTaskListener(new CommentListTask.CommentListTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(CommentListBean commentListBean) {
                if (commentListBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (commentListBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(commentListBean);
                    } else if (commentListBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(commentListBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        commentListTask.execute();
    }

    public static void fetchIssueList(HashMap<String, String> urlParams, final IssueListListener listener) {

        IssueListTask issueListTask = new IssueListTask(urlParams);
        issueListTask.setIssueListTaskListener(new IssueListTask.IssueListTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(IssueListBean issueListBean) {
                if (issueListBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (issueListBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(issueListBean);
                    } else if (issueListBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(issueListBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        issueListTask.execute();
    }

    public static void fetchRatingDetails(HashMap<String, String> urlParams, final RatingDetailsListener listener) {

        RatingDetailsTask ratingDetailsTask = new RatingDetailsTask(urlParams);
        ratingDetailsTask.setRatingDetailsTaskListener(new RatingDetailsTask.RatingDetailsTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(RatingDetailsBean ratingDetailsBean) {
                if (ratingDetailsBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (ratingDetailsBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(ratingDetailsBean);
                    } else if (ratingDetailsBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(ratingDetailsBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        ratingDetailsTask.execute();
    }

    public static void performUpdateDriverLocation(JSONObject postData, final BasicListener listener) {

        UpdateDriverLocationTask updateDriverLocationTask = new UpdateDriverLocationTask(postData);
        updateDriverLocationTask.setUpdateDriverLocationTaskListener(new UpdateDriverLocationTask.UpdateDriverLocationTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(BasicBean basicBean) {
                if (basicBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (basicBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(basicBean);
                    } else if (basicBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(basicBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        updateDriverLocationTask.execute();
    }

    public static void fetchWeeklyEarnings(HashMap<String, String> urlParams, final WeeklyEarningsListener listener) {

        WeeklyEarningsTask weeklyEarningsTask = new WeeklyEarningsTask(urlParams);
        weeklyEarningsTask.setWeeklyEarningsTaskListener(new WeeklyEarningsTask.WeeklyEarningsTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(WeeklyEarningsBean weeklyEarningsBean) {
                if (weeklyEarningsBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (weeklyEarningsBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(weeklyEarningsBean);
                    } else if (weeklyEarningsBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(weeklyEarningsBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        weeklyEarningsTask.execute();
    }

    public static void fetchPolyPoints(HashMap<String, String> urlParams, final PolyPointListener listener) {

        PolyPointTask polyPointTask = new PolyPointTask(urlParams);
        polyPointTask.setPolyPointTaskListener(new PolyPointTask.PolyPointTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(PolyPointBean polyPointBean) {
                if (polyPointBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (polyPointBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(polyPointBean);
                    } else if (polyPointBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(polyPointBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        polyPointTask.execute();
    }

    public static void fetchTripHistory(HashMap<String, String> urlParams, final TripListListener listener) {

        TripHistoryTask tripHistoryTask = new TripHistoryTask(urlParams);
        tripHistoryTask.setTripHistoryTaskListener(new TripHistoryTask.TripHistoryTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(TripListBean tripListBean) {
                if (tripListBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (tripListBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(tripListBean);
                    } else if (tripListBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(tripListBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        tripHistoryTask.execute();
    }

    public static void fetchTodayTripList(HashMap<String, String> urlParams, final TripListListener listener) {

        TodayTripListTask todayTripListTask = new TodayTripListTask(urlParams);
        todayTripListTask.setTodayTripListTaskListener(new TodayTripListTask.TodayTripListTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(TripListBean tripListBean) {
                if (tripListBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (tripListBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(tripListBean);
                    } else if (tripListBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(tripListBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        todayTripListTask.execute();
    }

    public static void performDriverStatusChange(JSONObject postData, final BasicListener listener) {

        DriverStatusChangeTask driverStatusChangeTask = new DriverStatusChangeTask(postData);
        driverStatusChangeTask.setDriverStatusChangeTaskListener(new DriverStatusChangeTask.DriverStatusChangeTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(BasicBean basicBean) {
                if (basicBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (basicBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(basicBean);
                    } else if (basicBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(basicBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        driverStatusChangeTask.execute();
    }

    public static void performUpdateFCMToken(JSONObject postData, final BasicListener listener) {

        UpdateFCMTokenTask updateFCMTokenTask = new UpdateFCMTokenTask(postData);
        updateFCMTokenTask.setUpdateFCMTokenTaskListener(new UpdateFCMTokenTask.UpdateFCMTokenTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(BasicBean basicBean) {
                if (basicBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (basicBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(basicBean);
                    } else if (basicBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(basicBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        updateFCMTokenTask.execute();
    }

    public static void performForgotPassword(JSONObject postData, final BasicListener listener) {

        ForgotPasswordTask forgotPasswordTask = new ForgotPasswordTask(postData);
        forgotPasswordTask.setForgotPasswordTaskListener(new ForgotPasswordTask.ForgotPasswordTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(BasicBean basicBean) {
                if (basicBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (basicBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(basicBean);
                    } else if (basicBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(basicBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        forgotPasswordTask.execute();
    }

    public static void performLogin(JSONObject postData, final LoginListener listener) {

        LoginTask loginTask = new LoginTask(postData);
        loginTask.setLoginTaskListener(new LoginTask.LoginTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(AuthBean authBean) {
                if (authBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (authBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(authBean);
                    } else if (authBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(authBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        loginTask.execute();
    }

    public static void fetchDocumentStatus(HashMap<String, String> urlParams, final DocumentStatusListener listener) {

        DocumentStatusTask documentStatusTask = new DocumentStatusTask(urlParams);
        documentStatusTask.setDocumentStatusTaskListener(new DocumentStatusTask.DocumentStatusTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(DocumentStatusBean documentStatusBean) {
                if (documentStatusBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (documentStatusBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(documentStatusBean);
                    } else if (documentStatusBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(documentStatusBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        documentStatusTask.execute();
    }

    public static void performRegistration(JSONObject postData, final RegistrationListener listener) {

        RegistrationTask registrationTask = new RegistrationTask(postData);
        registrationTask.setRegistrationTaskListener(new RegistrationTask.RegistrationTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(AuthBean authBean) {
                if (authBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (authBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(authBean);
                    } else if (authBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(authBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        registrationTask.execute();
    }

    public static void fetchProfile(HashMap<String, String> urlParams, final ProfileListener listener) {

        ProfileTask profileTask = new ProfileTask(urlParams);
        profileTask.setProfileTaskListener(new ProfileTask.ProfileTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(ProfileBean profileBean) {
                if (profileBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (profileBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(profileBean);
                    } else if (profileBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(profileBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        profileTask.execute();
    }

    public static void fetchDriverAccessibility(HashMap<String, String> urlParams, final AccessibilityListener accessibilityListener) {

        DriverAccessibilityTask driverAccessibilityTask = new DriverAccessibilityTask(urlParams);
        driverAccessibilityTask.setDriverAccessibilityTaskListener(new DriverAccessibilityTask.DriverAccessibilityTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(AccessibilityBean accessibilityBean) {
                if (accessibilityBean == null)
                    accessibilityListener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (accessibilityBean.getStatus().equalsIgnoreCase("Success")) {
                        accessibilityListener.onLoadCompleted(accessibilityBean);
                    } else if (accessibilityBean.getStatus().equalsIgnoreCase("Error")) {
                        accessibilityListener.onLoadFailed(accessibilityBean.getErrorMsg());
                    } else {
                        accessibilityListener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                accessibilityListener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        driverAccessibilityTask.execute();
    }

    public static void fetchTripSummary(HashMap<String, String> urlParams, final TripSummaryListener tripSummaryListener) {

        TripSummaryTask tripSummaryTask = new TripSummaryTask(urlParams);
        tripSummaryTask.setTripSummaryTaskListener(new TripSummaryTask.TripSummaryTaskListener() {

            @Override
            public void dataDownloadedSuccessfully(TripSummaryBean tripSummaryBean) {
                if (tripSummaryBean == null)
                    tripSummaryListener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (tripSummaryBean.getStatus().equalsIgnoreCase("Success")) {
                        tripSummaryListener.onLoadCompleted(tripSummaryBean);
                    } else if (tripSummaryBean.getStatus().equalsIgnoreCase("Error")) {
                        tripSummaryListener.onLoadFailed(tripSummaryBean.getErrorMsg());
                    } else {
                        tripSummaryListener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                tripSummaryListener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        tripSummaryTask.execute();
    }

    public static void performPhoneRegistration(JSONObject postData, final PhoneRegistrationListener listener) {

        PhoneRegistrationTask phoneRegistrationTask = new PhoneRegistrationTask(postData);
        phoneRegistrationTask.setPhoneRegistrationTaskListener(new PhoneRegistrationTask.PhoneRegistrationTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(AuthBean authBean) {
                if (authBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (authBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(authBean);
                    } else if (authBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(authBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        phoneRegistrationTask.execute();
    }

    public static void performOTPSubmit(JSONObject postData, final BasicListener listener) {

        OTPSubmitTask otpSubmitTask = new OTPSubmitTask(postData);
        otpSubmitTask.setOtpSubmitTaskListener(new OTPSubmitTask.OTPSubmitTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(BasicBean basicBean) {
                if (basicBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (basicBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(basicBean);
                    } else if (basicBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(basicBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        otpSubmitTask.execute();
    }

    public static void performOTPResendCode(JSONObject postData, final BasicListener listener) {

        OTPResendCodeTask otpResendCodeTask = new OTPResendCodeTask(postData);
        otpResendCodeTask.setOtpResendTaskListener(new OTPResendCodeTask.OTPResendTaskListener() {
            @Override
            public void dataDownloadedSuccessfully(BasicBean basicBean) {
                if (basicBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (basicBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(basicBean);
                    } else if (basicBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(basicBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        otpResendCodeTask.execute();
    }

    public static void performDriverTypeRegistration(JSONObject postData, final BasicListener listener) {

        DriverTypeRegistrationTask driverTypeRegistrationTask = new DriverTypeRegistrationTask(postData);
        driverTypeRegistrationTask.setDriverTypeRegistrationTaskListener(new DriverTypeRegistrationTask.DriverTypeRegistrationTaskListener() {

            @Override
            public void dataDownloadedSuccessfully(BasicBean basicBean) {
                if (basicBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (basicBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(basicBean);
                    } else if (basicBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(basicBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        driverTypeRegistrationTask.execute();
    }

    public static void performDocumentUpload(JSONObject postData, ArrayList<String> fileList, final BasicListener listener) {

        DocumentUploadTask documentUploadTask = new DocumentUploadTask(postData, fileList);
        documentUploadTask.setDocumentUploadTaskListener(new DocumentUploadTask.DocumentUploadTaskListener() {

            @Override
            public void dataDownloadedSuccessfully(BasicBean basicBean) {
                if (basicBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (basicBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(basicBean);
                    } else if (basicBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(basicBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        documentUploadTask.execute();
    }

    public static void performProfilePhotoUpload(JSONObject postData, ArrayList<String> fileList, final BasicListener listener) {

        ProfilePhotoUploadTask profilePhotoSaveTask = new ProfilePhotoUploadTask(postData, fileList);
        profilePhotoSaveTask.setProfilePhotoUploadTaskListener(new ProfilePhotoUploadTask.ProfilePhotoUploadTaskListener() {

            @Override
            public void dataDownloadedSuccessfully(BasicBean basicBean) {
                if (basicBean == null)
                    listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (basicBean.getStatus().equalsIgnoreCase("Success")) {
                        listener.onLoadCompleted(basicBean);
                    } else if (basicBean.getStatus().equalsIgnoreCase("Error")) {
                        listener.onLoadFailed(basicBean.getErrorMsg());
                    } else {
                        listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                listener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });
        profilePhotoSaveTask.execute();
    }

    public static void performDriverAccessibility(JSONObject postData, final BasicListener basicListener) {

        AccessibilityTask accessibilityTask = new AccessibilityTask(postData);
        accessibilityTask.setAccessibilityTaskListener(new AccessibilityTask.AccessibilityTaskListener() {

            @Override
            public void dataDownloadedSuccessfully(BasicBean basicBean) {
                if (basicBean == null)
                    basicListener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (basicBean.getStatus().equalsIgnoreCase("Success")) {
                        basicListener.onLoadCompleted(basicBean);
                    } else if (basicBean.getStatus().equalsIgnoreCase("Error")) {
                        basicListener.onLoadFailed(basicBean.getErrorMsg());
                    } else {
                        basicListener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                basicListener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });

        accessibilityTask.execute();
    }

    public static void performTripFeedback(JSONObject postData, final TripFeedbackListener tripFeedbackListener) {

        TripFeedbackTask tripFeedbackTask = new TripFeedbackTask(postData);
        tripFeedbackTask.setTripFeedbackTaskListener(new TripFeedbackTask.TripFeedbackTaskListener() {

            @Override
            public void dataDownloadedSuccessfully(TripFeedbackBean tripFeedbackBean) {
                if (tripFeedbackBean == null)
                    tripFeedbackListener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                else {
                    if (tripFeedbackBean.getStatus().equalsIgnoreCase("Success")) {
                        tripFeedbackListener.onLoadCompleted(tripFeedbackBean);
                    } else if (tripFeedbackBean.getStatus().equalsIgnoreCase("Error")) {
                        tripFeedbackListener.onLoadFailed(tripFeedbackBean.getErrorMsg());
                    } else {
                        tripFeedbackListener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
                    }
                }
            }

            @Override
            public void dataDownloadFailed() {
                tripFeedbackListener.onLoadFailed(AppConstants.WEB_ERROR_MSG);
            }
        });

        tripFeedbackTask.execute();
    }
}
