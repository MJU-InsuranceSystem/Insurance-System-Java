package org.example.business.education.usecase;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.example.Team;
import org.example.business.education.view.EducationView;
import org.example.common.usecase.Usecase;
import org.example.common.dto.RequestDto;
import org.example.common.dto.ResponseDto;

public enum EducationUseCase implements Usecase {

    PREPARE_EDUCATION(1, "영업 교육을 준비한다.",
        EducationView::prepareEducation, Team::register, EducationView::completeMessage),
    MANAGE_EDUCATION(2, "영업 교육을 관리한다.",
        EducationView::manageEducation, Team::process, EducationView::completeMessage),
    MANAGE_EDUCATION_STUDENT(3, "교육대상자/수료생을 관리한다.",
        EducationView::manageEducationStudent, Team::process, EducationView::completeMessage);

    private final int order;
    private final String description;

    private final Function<EducationView, RequestDto> action;
    private final BiFunction<Team, RequestDto, ResponseDto> teamAction;
    private final BiConsumer<EducationView, ResponseDto> showResult;


    EducationUseCase(int order, String description, Function<EducationView, RequestDto> action,
        BiFunction<Team, RequestDto, ResponseDto> teamAction,
        BiConsumer<EducationView, ResponseDto> showResult) {
        this.order = order;
        this.description = description;
        this.action = action;
        this.teamAction = teamAction;
        this.showResult = showResult;
    }

    public String getDescription() {
        return description;
    }

    public int getOrder() {
        return order;
    }

    public RequestDto viewAction(EducationView educationView) {
        return action.apply(educationView);
    }

    public ResponseDto teamAction(Team team, RequestDto responseDto) {
        return teamAction.apply(team, responseDto);
    }

    public void showResult(EducationView view, ResponseDto responseDto) {
        this.showResult.accept(view, responseDto);
    }

    public static EducationUseCase findByNumber(int selectNumber) {
        return Arrays.stream(EducationUseCase.values())
            .filter(usecase -> usecase.getOrder() == selectNumber)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("해당 유스케이스 번호를 찾을 수 없습니다."));
    }
}
