# https://dodona.ugent.be/nl/courses/119/series/1392/exercises/1477658312
def subsetsom(lijst, goal):
    checklist = []

    for x in range(len(lijst)):
        if lijst[x] > goal:
            checklist.append(False)
        else:
            checklist.append(True)
