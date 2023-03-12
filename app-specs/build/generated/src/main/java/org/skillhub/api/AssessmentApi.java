/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.skillhub.api;

import org.skillhub.model.Assessment;
import org.skillhub.model.Error;
import org.skillhub.model.PreviewAssessment;
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
@Tag(name = "assessment", description = "the assessment API")
public interface AssessmentApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /assessment : save new assessment
     * save new assessment
     *
     * @param principal Security Principal (required)
     * @param assessment assessment payload (optional)
     * @return Success (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Internal Server Error (status code 500)
     *         or  (status code 502)
     *         or  (status code 504)
     */
    @Operation(
        operationId = "createAssessment",
        summary = "save new assessment",
        tags = { "assessment" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Assessment.class))
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
        value = "/assessment",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Assessment> createAssessment(
        @NotNull @Parameter(name = "principal", description = "Security Principal", required = true) @Valid java.security.Principal principal,
        @Parameter(name = "Assessment", description = "assessment payload") @Valid @RequestBody(required = false) Assessment assessment
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"assessmentPeople\" : [ { \"skills\" : [ { \"score\" : 6.027456183070403, \"name\" : \"name\" }, { \"score\" : 6.027456183070403, \"name\" : \"name\" } ], \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"image\" : { \"data\" : \"data\", \"name\" : \"name\", \"type\" : \"type\" }, \"certificates\" : [ { \"expirationYear\" : \"expirationYear\", \"issueYear\" : \"issueYear\", \"name\" : \"name\", \"expirationMonth\" : \"expirationMonth\", \"issueMonth\" : \"issueMonth\" }, { \"expirationYear\" : \"expirationYear\", \"issueYear\" : \"issueYear\", \"name\" : \"name\", \"expirationMonth\" : \"expirationMonth\", \"issueMonth\" : \"issueMonth\" } ], \"about\" : \"about\", \"id\" : 0, \"team\" : \"team\", \"position\" : \"position\", \"username\" : \"username\" }, { \"skills\" : [ { \"score\" : 6.027456183070403, \"name\" : \"name\" }, { \"score\" : 6.027456183070403, \"name\" : \"name\" } ], \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"image\" : { \"data\" : \"data\", \"name\" : \"name\", \"type\" : \"type\" }, \"certificates\" : [ { \"expirationYear\" : \"expirationYear\", \"issueYear\" : \"issueYear\", \"name\" : \"name\", \"expirationMonth\" : \"expirationMonth\", \"issueMonth\" : \"issueMonth\" }, { \"expirationYear\" : \"expirationYear\", \"issueYear\" : \"issueYear\", \"name\" : \"name\", \"expirationMonth\" : \"expirationMonth\", \"issueMonth\" : \"issueMonth\" } ], \"about\" : \"about\", \"id\" : 0, \"team\" : \"team\", \"position\" : \"position\", \"username\" : \"username\" } ], \"assessmentFor\" : { \"skills\" : [ { \"score\" : 6.027456183070403, \"name\" : \"name\" }, { \"score\" : 6.027456183070403, \"name\" : \"name\" } ], \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"image\" : { \"data\" : \"data\", \"name\" : \"name\", \"type\" : \"type\" }, \"certificates\" : [ { \"expirationYear\" : \"expirationYear\", \"issueYear\" : \"issueYear\", \"name\" : \"name\", \"expirationMonth\" : \"expirationMonth\", \"issueMonth\" : \"issueMonth\" }, { \"expirationYear\" : \"expirationYear\", \"issueYear\" : \"issueYear\", \"name\" : \"name\", \"expirationMonth\" : \"expirationMonth\", \"issueMonth\" : \"issueMonth\" } ], \"about\" : \"about\", \"id\" : 0, \"team\" : \"team\", \"position\" : \"position\", \"username\" : \"username\" }, \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /assessment/all : get all assessment
     * get all assessment
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
        operationId = "getAllAssessments",
        summary = "get all assessment",
        tags = { "assessment" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Assessment.class))
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
        value = "/assessment/all",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Assessment>> getAllAssessments(
        @NotNull @Parameter(name = "principal", description = "Security Principal", required = true) @Valid java.security.Principal principal
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"assessmentPeople\" : [ { \"skills\" : [ { \"score\" : 6.027456183070403, \"name\" : \"name\" }, { \"score\" : 6.027456183070403, \"name\" : \"name\" } ], \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"image\" : { \"data\" : \"data\", \"name\" : \"name\", \"type\" : \"type\" }, \"certificates\" : [ { \"expirationYear\" : \"expirationYear\", \"issueYear\" : \"issueYear\", \"name\" : \"name\", \"expirationMonth\" : \"expirationMonth\", \"issueMonth\" : \"issueMonth\" }, { \"expirationYear\" : \"expirationYear\", \"issueYear\" : \"issueYear\", \"name\" : \"name\", \"expirationMonth\" : \"expirationMonth\", \"issueMonth\" : \"issueMonth\" } ], \"about\" : \"about\", \"id\" : 0, \"team\" : \"team\", \"position\" : \"position\", \"username\" : \"username\" }, { \"skills\" : [ { \"score\" : 6.027456183070403, \"name\" : \"name\" }, { \"score\" : 6.027456183070403, \"name\" : \"name\" } ], \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"image\" : { \"data\" : \"data\", \"name\" : \"name\", \"type\" : \"type\" }, \"certificates\" : [ { \"expirationYear\" : \"expirationYear\", \"issueYear\" : \"issueYear\", \"name\" : \"name\", \"expirationMonth\" : \"expirationMonth\", \"issueMonth\" : \"issueMonth\" }, { \"expirationYear\" : \"expirationYear\", \"issueYear\" : \"issueYear\", \"name\" : \"name\", \"expirationMonth\" : \"expirationMonth\", \"issueMonth\" : \"issueMonth\" } ], \"about\" : \"about\", \"id\" : 0, \"team\" : \"team\", \"position\" : \"position\", \"username\" : \"username\" } ], \"assessmentFor\" : { \"skills\" : [ { \"score\" : 6.027456183070403, \"name\" : \"name\" }, { \"score\" : 6.027456183070403, \"name\" : \"name\" } ], \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"image\" : { \"data\" : \"data\", \"name\" : \"name\", \"type\" : \"type\" }, \"certificates\" : [ { \"expirationYear\" : \"expirationYear\", \"issueYear\" : \"issueYear\", \"name\" : \"name\", \"expirationMonth\" : \"expirationMonth\", \"issueMonth\" : \"issueMonth\" }, { \"expirationYear\" : \"expirationYear\", \"issueYear\" : \"issueYear\", \"name\" : \"name\", \"expirationMonth\" : \"expirationMonth\", \"issueMonth\" : \"issueMonth\" } ], \"about\" : \"about\", \"id\" : 0, \"team\" : \"team\", \"position\" : \"position\", \"username\" : \"username\" }, \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /assessment/review : get assessments to review
     * get assessments to review
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
        operationId = "getAssessmentsToReview",
        summary = "get assessments to review",
        tags = { "assessment" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PreviewAssessment.class))
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
        value = "/assessment/review",
        produces = { "application/json" }
    )
    default ResponseEntity<List<PreviewAssessment>> getAssessmentsToReview(
        @NotNull @Parameter(name = "principal", description = "Security Principal", required = true) @Valid java.security.Principal principal
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"skills\" : [ { \"score\" : 6.027456183070403, \"name\" : \"name\" }, { \"score\" : 6.027456183070403, \"name\" : \"name\" } ], \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"username\" : \"username\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}