package com.hero_associatition.models.enumerations;

/**
 * Created by markoreljic on 1.12.16..
 */

public enum ExceptionMessages {

    INVALID_INPUT_PARAMETERS("Invalid input parameters"),
    EMAIL_IN_DATABASE("Email exists in database"),
    DEVICE_IN_DATABASE("Device exists in database"),
    DEVICE_NOT_IN_DATABASE("Device doesn't exist in database"),
    FILE_IS_EMPTY("File is empty"),
    FILE_NOT_FOUND("File couldn't be retrieved from filesystem"),
    FILE_PARSING_ERROR("File couldn't be parsed"),
    CITY_GUIDE_NOT_IN_DATABASE("City guide doesn't exist in database"),
    FOOD_GUIDE_IN_DATABASE("Food guide with given name already exists in database"),
    HOTEL_GUIDE_IN_DATABASE("Hotel guide with given name already exists in database"),
    CITY_GUIDE_IN_DATABASE("City guide with given name already exists in database"),
    FOOD_GUIDE_NOT_IN_DATABASE("Food guide doesn't exist in database"),
    HOTEL_GUIDE_NOT_IN_DATABASE("Hotel guide doesn't exist in database"),
    HOTEL_NOT_IN_DATABASE("Hotel doesn't exist in database"),
    USER_NOT_IN_DATABASE("User doesn't exist in database"),
    COUNTRY_NOT_IN_DATABASE("Country doesn't exist in database"),
    HOTEL_MEDIA_NOT_IN_DATABASE("Hotel media doesn't exist in database"),
    MEDIA_NOT_IN_DATABASE("Media doesn't exist in database"),
    BOTH_DEVICES_BROKEN("Both devices are broken"),
    LANGUAGE_GROUP_NOT_IN_DATABASE("Language group doesn't exist in database"),
    LANGUAGE_GROUP_LANGUAGE_NOT_IN_DATABASE("Language group language doesn't exist in database"),
    CATEGORY_LIST_NOT_IN_DATABASE("Category list doesn't exist in database"),
    CITY_GUIDE_NOT_IN_THIS_HOTEL("Content is in city guide which isn't assigned in this hotel"),
    FOOD_GUIDE_NOT_IN_THIS_HOTEL("Content is in food guide which isn't assigned in this hotel"),
    HOTEL_GUIDE_NOT_IN_THIS_HOTEL("Content is in hotel guide which isn't assigned in this hotel"),
    CONTENT_NOT_IN_DATABASE("Content with those parameters not found in database"),
    CONTENT_NOT_IN_THIS_HOTEL("Content isn't assigned in this hotel"),
    SUPER_ADMIN_NOT_ALLOWED("Super admin not allowed to perform action"),
    TERMS_AND_CONDITIONS_NOT_IN_DATABASE("Terms and conditions not defined for this hotel"),
    NO_DEFAULT_LANGUAGE_FOR_DEVICE("There is no default language in the database for this device"),
    NO_DEFAULT_LANGUAGE_FOR_HOTEL("There is no default language in the database for your hotel"),
    HOTEL_SOCIAL_NOT_IN_DATABASE("There is no socials in the database"),
    DEVICES_NOT_DEFINED("There are no devices defined"),
    PUSH_MESSAGE_NOT_IN_DATABASE("Push message doesn't exist in database"),
    CONCIERGE_NOT_IN_DATABASE("Concierge doesn't exist in hotel"),
    CONVERSATION_NOT_IN_DATABASE("Conversation doesn't exist in database"),
    DEVICE_SETTINGS_NOT_IN_DATABASE("Device settings doesn't exist in database"),
    DEVICE_FAVOURITE_IN_DATABASE("Device favourite exists in database"),
    DEVICE_FAVOURITE_NOT_IN_DATABASE("Device favourite doesn't exist in database"),
    DEVICE_SCHEDULE_IN_DATABASE("Device schedule exists in database"),
    DEVICE_SCHEDULE_NOT_IN_DATABASE("Device schedule doesn't exist in database"),
    DEVICE_GOOGLE_CLOUD_TOKEN_MISSING("Device doesn't have google cloud token defined"),
    CONCIERGE_DEVICE_NOT_IN_DATABASE("Concierge device doesn't exist in the database"),
    DEVICES_NOT_BELONG_SAME_HOTEL("Devices don't correspond to the same hotel"),
    REQUEST_NOT_IN_DATABASE("Request doesn't exist in the database"),
    NO_ACTIVE_REVIEWS_FOR_DEVICE("No active reviews for selected device"),
    USER_NOT_ASSIGNED_TO_HOTEL("User not assigned to any hotel"),
    TRAINING_MATERIAL_NOT_IN_DATABASE("Training material not in database"),
    NO_IMAGE_FOR_CONTENT("Image for given content doesn't exist in the database"),
    DEVICE_IS_ASSIGNED_TO_CONCIERGE("This device is assigned to concierge"),
    DEVICE_NAME_NOT_IN_RIGHT_FORMAT("Device name is not in right format ROOMTYPE_ROOMNUMBER"),
    SWAP_DEVICE_WITH_ITSELF("Device can't be swapped with itself"),
    USER_WITH_EMAIL_NOT_IN_DATABASE("User with that email doesn't exist in database"),
    ROLE_CREATION_FORBIDDEN("User with selected role can not be created"),
    DEVICE_IS_ASSIGNED_TO_HOTEL("Device is assigned to hotel"),
    USER_CANNOT_DELETE_ITSELF("User can not delete himself/herself"),
    PASSWORD_IS_SAME_AS_PREVIOUS_ONE("New password must be different from the current one"),
    START_DATE_TIME_BEFORE_NOW("Start datetime can not be before now"),
    END_DATE_TIME_BEFORE_NOW("End datetime can not be before now"),
    START_DATE_TIME_AFTER_END("Start datetime can not be after end datetime"),
    PROVIDED_AUTHENTICATION_LINK_INVALID_OR_EXPIRED("The authentication link you provided is either invalid or has expired! Please contact your administrator."),
    INADEQUATE_ROLE("Device doesn't belong to concierge"),
    GUIDE_NOT_IN_THIS_HOTEL("Content is in guide which isn't assigned in this hotel"),
    LANGUAGE_GROUP_NOT_SET("Language group is not set"),
    USER_NOT_AUTHENTICATED("User has to complete the registration process first"),
    CATEGORY_NOT_IN_DATABASE("Category not in database"),
    LIST_OF_CONTENTS_TO_UPDATE_EMPTY("List of contents sent is empty!");

    private final String text;

    private ExceptionMessages(final String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}

