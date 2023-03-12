/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.skillhub.api;

import org.skillhub.model.Error;
import org.skillhub.model.Profile;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-09T00:13:10.588332+04:00[Asia/Yerevan]")
@Validated
@Tag(name = "profile", description = "the profile API")
public interface ProfileApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /profile : Fetch profile of the current user
     * Fetch profile of the current user
     *
     * @param principal Security Principal (required)
     * @return Success (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Internal Server Error (status code 500)
     *         or  (status code 502)
     *         or  (status code 504)
     */
    @Operation(
        operationId = "getProfile",
        summary = "Fetch profile of the current user",
        tags = { "profile" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Profile.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "502", description = ""),
            @ApiResponse(responseCode = "504", description = "")
        },
        security = {
            @SecurityRequirement(name = "jwt")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/profile",
        produces = { "application/json" }
    )
    default ResponseEntity<Profile> getProfile(
        @NotNull @Parameter(name = "principal", description = "Security Principal", required = true) @Valid java.security.Principal principal
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"skills\" : [ { \"score\" : 6.027456183070403, \"name\" : \"name\" }, { \"score\" : 6.027456183070403, \"name\" : \"name\" } ], \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"image\" : { \"data\" : \"data\", \"name\" : \"name\", \"type\" : \"type\" }, \"certificates\" : [ { \"expirationYear\" : \"expirationYear\", \"issueYear\" : \"issueYear\", \"name\" : \"name\", \"expirationMonth\" : \"expirationMonth\", \"issueMonth\" : \"issueMonth\" }, { \"expirationYear\" : \"expirationYear\", \"issueYear\" : \"issueYear\", \"name\" : \"name\", \"expirationMonth\" : \"expirationMonth\", \"issueMonth\" : \"issueMonth\" } ], \"about\" : \"about\", \"id\" : 0, \"team\" : \"team\", \"position\" : \"position\", \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /profile/all : Fetch all profiles
     * Fetch all profiles
     *
     * @param principal Security Principal (required)
     * @return Success (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Internal Server Error (status code 500)
     *         or  (status code 502)
     *         or  (status code 504)
     */
    @Operation(
        operationId = "getProfiles",
        summary = "Fetch all profiles",
        tags = { "profile" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Profile.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "502", description = ""),
            @ApiResponse(responseCode = "504", description = "")
        },
        security = {
            @SecurityRequirement(name = "jwt")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/profile/all",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Profile>> getProfiles(
        @NotNull @Parameter(name = "principal", description = "Security Principal", required = true) @Valid java.security.Principal principal
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"skills\" : [ { \"score\" : 6.027456183070403, \"name\" : \"name\" }, { \"score\" : 6.027456183070403, \"name\" : \"name\" } ], \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"image\" : { \"data\" : \"data\", \"name\" : \"name\", \"type\" : \"type\" }, \"certificates\" : [ { \"expirationYear\" : \"expirationYear\", \"issueYear\" : \"issueYear\", \"name\" : \"name\", \"expirationMonth\" : \"expirationMonth\", \"issueMonth\" : \"issueMonth\" }, { \"expirationYear\" : \"expirationYear\", \"issueYear\" : \"issueYear\", \"name\" : \"name\", \"expirationMonth\" : \"expirationMonth\", \"issueMonth\" : \"issueMonth\" } ], \"about\" : \"about\", \"id\" : 0, \"team\" : \"team\", \"position\" : \"position\", \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /profile : Update a profile
     * Update a profile
     *
     * @param profile Profile payload (required)
     * @return Success (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Internal Server Error (status code 500)
     *         or  (status code 502)
     *         or  (status code 504)
     */
    @Operation(
        operationId = "updateProfile",
        summary = "Update a profile",
        tags = { "profile" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Profile.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "502", description = ""),
            @ApiResponse(responseCode = "504", description = "")
        },
        security = {
            @SecurityRequirement(name = "jwt")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/profile",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Profile> updateProfile(
        @Parameter(name = "Profile", description = "Profile payload", required = true) @Valid @RequestBody Profile profile
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"skills\" : [ { \"score\" : 6.027456183070403, \"name\" : \"name\" }, { \"score\" : 6.027456183070403, \"name\" : \"name\" } ], \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"image\" : { \"data\" : \"data\", \"name\" : \"name\", \"type\" : \"type\" }, \"certificates\" : [ { \"expirationYear\" : \"expirationYear\", \"issueYear\" : \"issueYear\", \"name\" : \"name\", \"expirationMonth\" : \"expirationMonth\", \"issueMonth\" : \"issueMonth\" }, { \"expirationYear\" : \"expirationYear\", \"issueYear\" : \"issueYear\", \"name\" : \"name\", \"expirationMonth\" : \"expirationMonth\", \"issueMonth\" : \"issueMonth\" } ], \"about\" : \"about\", \"id\" : 0, \"team\" : \"team\", \"position\" : \"position\", \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /profile/image : Upload a profile image
     * Upload a profile image
     *
     * @param principal Security Principal (required)
     * @param file  (optional)
     * @return Success (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Internal Server Error (status code 500)
     *         or  (status code 502)
     *         or  (status code 504)
     */
    @Operation(
        operationId = "uploadProfileImage",
        summary = "Upload a profile image",
        tags = { "profile" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "502", description = ""),
            @ApiResponse(responseCode = "504", description = "")
        },
        security = {
            @SecurityRequirement(name = "jwt")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/profile/image",
        produces = { "application/json" },
        consumes = { "multipart/form-data" }
    )
    default ResponseEntity<Void> uploadProfileImage(
        @NotNull @Parameter(name = "principal", description = "Security Principal", required = true) @Valid java.security.Principal principal,
        @Parameter(name = "file", description = "") @Valid @RequestParam(value = "file", required = false) Object file
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}