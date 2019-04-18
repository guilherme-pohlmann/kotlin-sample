package myFirstKotlinSpringApp

import com.google.common.base.Predicates
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.beans
import springfox.documentation.builders.PathSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
internal class configuration : ApplicationContextInitializer<GenericApplicationContext> {
    private fun beans() = beans {
        bean { Docket(DocumentationType.SWAGGER_2).select().paths(swaggerPaths()).build() }
    }

    private fun swaggerPaths() = Predicates.or(PathSelectors.regex("/calculator/.*"))

    override fun initialize(context: GenericApplicationContext) = beans().initialize(context)

}