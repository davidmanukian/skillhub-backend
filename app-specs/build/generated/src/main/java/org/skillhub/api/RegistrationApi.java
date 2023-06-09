/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.skillhub.api;

import org.skillhub.model.Error;
import org.skillhub.model.RegistrationPayload;
import org.skillhub.model.RegistrationResponse;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-03-14T19:45:14.512692+04:00[Asia/Yerevan]")
@Validated
@Tag(name = "registration", description = "the registration API")
public interface RegistrationApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /registration : register new user
     * register new user
     *
     * @param registrationPayload register payload (optional)
     * @return Success (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Internal Server Error (status code 500)
     *         or  (status code 502)
     *         or  (status code 504)
     */
    @Operation(
        operationId = "register",
        summary = "register new user",
        tags = { "registration" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Success", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = RegistrationResponse.class))
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
        value = "/registration",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<RegistrationResponse> register(
        @Parameter(name = "RegistrationPayload", description = "register payload") @Valid @RequestBody(required = false) RegistrationPayload registrationPayload
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"token\" : \"token\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
